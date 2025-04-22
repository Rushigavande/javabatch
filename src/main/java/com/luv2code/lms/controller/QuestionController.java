package com.luv2code.lms.controller;
import com.luv2code.lms.model.Question;
import com.luv2code.lms.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @GetMapping
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @GetMapping("/{quizId}")
    public List<Question> getQuestionsByQuizId(@PathVariable Long quizId) {
        return questionRepository.findByQuizId(quizId);
    }

    @PostMapping
    public Question createQuestion(@RequestBody Question question) {
        return questionRepository.save(question);
    }

    @PutMapping("/{id}")
    public Question updateQuestion(@PathVariable Long id, @RequestBody Question question) {
        question.setId(id);
        return questionRepository.save(question);
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable Long id) {
        questionRepository.deleteById(id);
    }
}

