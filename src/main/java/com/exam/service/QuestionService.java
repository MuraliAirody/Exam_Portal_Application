package com.exam.service;

import com.exam.entity.exam.Question;
import com.exam.entity.exam.Quiz;

import java.util.Set;

public interface QuestionService {
    public Question addQuestion(Question question);
    public Question updateQuestion(Question question);
    public Set<Question> getQuestions();
    public  Question getQuestion(long quesid);
    public void deleteQuestion(long quesid);
    public Set<Question> getQuestionOfQuiz(Quiz quiz);
}
