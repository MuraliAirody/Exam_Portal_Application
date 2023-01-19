package com.exam.repo;

import com.exam.entity.exam.Category;
import com.exam.entity.exam.Quiz;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface QuizRepository extends JpaRepository<Quiz,Long> {
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM quiz WHERE q_Id = ?1", nativeQuery = true)
    public void deleteQuiz(Long qid);

    public Set<Quiz> findByCategory(Category category);

    public Set<Quiz> findByActive(Boolean b);

    public Set<Quiz> findByCategoryAndActive(Category category,Boolean b);
}
