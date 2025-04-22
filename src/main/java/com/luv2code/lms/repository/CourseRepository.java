package com.luv2code.lms.repository;

import com.luv2code.lms.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByCreatedBy(Long userId);
}

