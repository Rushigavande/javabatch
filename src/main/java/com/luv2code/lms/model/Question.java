package com.luv2code.lms.model;

import jakarta.persistence.*;

@Entity
public class Question {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long quizId;
    private String questionText;
    private String options;       // Comma-separated
    private String correctAnswer;

    public Question() {
    }

    public Question(Long id, Long quizId, String questionText, String correctAnswer, String options) {
        this.id = id;
        this.quizId = quizId;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.options = options;
    }
// Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }
}
