package com.luv2code.lms.repository;

import com.luv2code.lms.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score, Long> {
    List<Score> findByUserId(Long userId);
    List<Score> findByQuizId(Long quizId);
}

