package com.exam.service.impl;

import com.exam.entity.exam.Quiz;
import com.exam.repo.QuestionRepository;
import com.exam.repo.QuizRepository;
import com.exam.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;
    @Override
    public Quiz addQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Set<Quiz> getQuizzes() {
        return new HashSet<>(this.quizRepository.findAll());
    }

    @Override
    public Quiz getQuiz(long qid) {
        return this.quizRepository.findById(qid).get();
    }

    @Override
    public void deleteQuiz(long qid) {
        Quiz quiz = new Quiz();
        quiz.setqId(qid);
        this.quizRepository.deleteQuiz(qid);
    }
}
