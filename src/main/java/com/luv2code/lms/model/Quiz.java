package com.luv2code.lms.model;

import jakarta.persistence.*;

@Entity
public class Quiz {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long courseId;
    private String title;

    public Quiz() {
    }

    public Quiz(Long id, Long courseId, String title) {
        this.id = id;
        this.courseId = courseId;
        this.title = title;
    }
// Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
