package com.luv2code.lms.controller;
import com.luv2code.lms.model.Quiz;
import com.luv2code.lms.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    private final QuizRepository quizRepository;

    @Autowired
    public QuizController(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @GetMapping
    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    @GetMapping("/{courseId}")
    public List<Quiz> getQuizzesByCourseId(@PathVariable Long courseId) {
        return quizRepository.findByCourseId(courseId);
    }

    @PostMapping
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @PutMapping("/{id}")
    public Quiz updateQuiz(@PathVariable Long id, @RequestBody Quiz quiz) {
        quiz.setId(id);
        return quizRepository.save(quiz);
    }

    @DeleteMapping("/{id}")
    public void deleteQuiz(@PathVariable Long id) {
        quizRepository.deleteById(id);
    }
}

