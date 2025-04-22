package com.luv2code.lms.model;

import jakarta.persistence.*;
        import java.time.LocalDate;

@Entity
public class Enrollment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long courseId;
    private LocalDate dateEnrolled;

    public Enrollment() {
    }

    public Enrollment(Long id, Long userId, Long courseId, LocalDate dateEnrolled) {
        this.id = id;
        this.userId = userId;
        this.courseId = courseId;
        this.dateEnrolled = dateEnrolled;
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

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public LocalDate getDateEnrolled() {
        return dateEnrolled;
    }

    public void setDateEnrolled(LocalDate dateEnrolled) {
        this.dateEnrolled = dateEnrolled;
    }
}
