package com.luv2code.lms.model;

import jakarta.persistence.*;
        import java.time.LocalDate;

@Entity
public class Score {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long quizId;
    private int score;
    private LocalDate dateTaken;

    public Score() {
    }

    public Score(Long id, Long userId, Long quizId, int score, LocalDate dateTaken) {
        this.id = id;
        this.userId = userId;
        this.quizId = quizId;
        this.score = score;
        this.dateTaken = dateTaken;
    }
// Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public LocalDate getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(LocalDate dateTaken) {
        this.dateTaken = dateTaken;
    }
}
