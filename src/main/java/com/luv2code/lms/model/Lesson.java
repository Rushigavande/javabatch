package com.luv2code.lms.model;


import jakarta.persistence.*;

@Entity
public class Lesson {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long courseId;
    private String title;
    private String content;

    public Lesson() {
    }

    public Lesson(Long id, Long courseId, String content, String title) {
        this.id = id;
        this.courseId = courseId;
        this.content = content;
        this.title = title;
    }
// Getters & Setters

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
