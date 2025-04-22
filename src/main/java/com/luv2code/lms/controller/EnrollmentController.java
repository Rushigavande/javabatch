package com.luv2code.lms.controller;
import com.luv2code.lms.model.Enrollment;
import com.luv2code.lms.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    private final EnrollmentRepository enrollmentRepository;

    @Autowired
    public EnrollmentController(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    @GetMapping
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    @GetMapping("/{userId}")
    public List<Enrollment> getEnrollmentsByUserId(@PathVariable Long userId) {
        return enrollmentRepository.findByUserId(userId);
    }

    @PostMapping
    public Enrollment enrollUser(@RequestBody Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @DeleteMapping("/{id}")
    public void deleteEnrollment(@PathVariable Long id) {
        enrollmentRepository.deleteById(id);
    }
}
