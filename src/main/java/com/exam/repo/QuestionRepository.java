package com.exam.repo;

import com.exam.entity.exam.Question;
import com.exam.entity.exam.Quiz;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface QuestionRepository extends JpaRepository<Question,Long> {

    Set<Question> findByQuiz(Quiz quiz);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM question WHERE ques_Id = ?1", nativeQuery = true)
    public void deleteQuestion(Long qid);
}
