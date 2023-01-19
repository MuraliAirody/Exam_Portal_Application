package com.exam.service;

import com.exam.entity.exam.Category;
import com.exam.entity.exam.Quiz;

import java.util.Set;

public interface QuizService {
    public Quiz addQuiz(Quiz quiz);
    public Quiz updateQuiz(Quiz quiz);
    public Set<Quiz> getQuizzes();
    public Quiz getQuiz(long qid);
    public void deleteQuiz(long qid);

   public Set<Quiz> getQuizByCategory(Category category);

   public  Set<Quiz> getActiveQuiz();

   public Set<Quiz> getActiveQuizOfCategory(Category category);
}
