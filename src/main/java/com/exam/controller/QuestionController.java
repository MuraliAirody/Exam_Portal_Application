package com.exam.controller;

import com.exam.entity.exam.Question;
import com.exam.entity.exam.Quiz;
import com.exam.service.QuestionService;
import com.exam.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@RestController
@RequestMapping("/question")
@CrossOrigin
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuizService quizService;

    @PostMapping("/")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question){
        return ResponseEntity.ok(this.questionService.addQuestion(question));
    }
    @GetMapping("/{quesid}")
    public ResponseEntity<Question> getQuestion(@PathVariable("quesid")long quesid){
        return ResponseEntity.ok(this.questionService.getQuestion(quesid));
    }
    @GetMapping("/all")
    public ResponseEntity<?> getQuestions(){
        return ResponseEntity.ok(this.questionService.getQuestions());
    }

    @PutMapping("/")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question){
        return ResponseEntity.ok(this.questionService.updateQuestion(question));
    }
    @DeleteMapping("/{quesid}")
    public void deleteQuestion(@PathVariable("quesid")long quesid){
         this.questionService.deleteQuestion(quesid);
    }

    @GetMapping("/quiz/{qid}")
    public ResponseEntity<?> getQuestions(@PathVariable("qid")long qid){
        Quiz quiz = this.quizService.getQuiz(qid);
        System.out.println(quiz.getTitle());
        System.out.println("no of ques " + String.valueOf(quiz.getNumberOfQuestions()));
        System.out.println("ques "+quiz.getQuestions());



        Set<Question> questions = quiz.getQuestions();
        ArrayList<Question> list = new ArrayList<>(questions);
        if(list.size()>Integer.parseInt(String.valueOf(quiz.getNumberOfQuestions()))){
            list.subList(0,Integer.parseInt(String.valueOf(quiz.getNumberOfQuestions()+1)));
        }
        Collections.shuffle(list);
        return  ResponseEntity.ok(list);

    }

    @GetMapping("/quiz/all/{qid}")
    public ResponseEntity<?> getALllQuestionsOfId(@PathVariable("qid")long qid){
         Quiz quiz = new Quiz();
         quiz.setqId(qid);
        Set<Question> questionOfQuiz = this.questionService.getQuestionOfQuiz(quiz);

        return ResponseEntity.ok(questionOfQuiz);
    }

}
