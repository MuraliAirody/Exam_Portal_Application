package com.exam.controller;

import com.exam.entity.exam.Category;
import com.exam.entity.exam.Quiz;
import com.exam.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;
    @PostMapping("/")
    public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz){
       return ResponseEntity.ok(this.quizService.addQuiz(quiz));
    }
    @GetMapping("/{qid}")
    public ResponseEntity<Quiz> getQuiz(@PathVariable("qid")long qid){
        System.out.println("getting a quiz");
        return ResponseEntity.ok(this.quizService.getQuiz(qid));
    }

    @GetMapping("/")
    public ResponseEntity<?> getQuizzes(){
        return ResponseEntity.ok(this.quizService.getQuizzes());
    }
    @PutMapping("/")
    public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz){
        return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
    }
    @DeleteMapping("/{qid}")
    public void deleteQuiz(@PathVariable("qid")long qid){
        this.quizService.deleteQuiz(qid);
    }


    //getting the quiz by using category ID
    @GetMapping("/category/{cId}")
    public ResponseEntity<?> getQuizByCategory(@PathVariable("cId")long cId){
        Category category = new Category();
        category.setcId(cId);

        return ResponseEntity.ok(this.quizService.getQuizByCategory(category));

    }

    @GetMapping("/active")
    public ResponseEntity<?> getActiveQuiz(){
        return ResponseEntity.ok(this.quizService.getActiveQuiz());
    }

    @GetMapping("/category/active/{cId}")
    public ResponseEntity<?> getActiveQuizOfCategory(@PathVariable("cId")long cId){
        Category category = new Category();
        category.setcId(cId);
        return ResponseEntity.ok(this.quizService.getActiveQuizOfCategory(category));
    }

}
