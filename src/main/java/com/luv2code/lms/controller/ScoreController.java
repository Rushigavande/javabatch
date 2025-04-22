package com.luv2code.lms.controller;

import com.luv2code.lms.model.Score;
import com.luv2code.lms.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scores")
public class ScoreController {

    private final ScoreRepository scoreRepository;

    @Autowired
    public ScoreController(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    @GetMapping
    public List<Score> getAllScores() {
        return scoreRepository.findAll();
    }

    @GetMapping("/{userId}")
    public List<Score> getScoresByUserId(@PathVariable Long userId) {
        return scoreRepository.findByUserId(userId);
    }

    @PostMapping
    public Score createScore(@RequestBody Score score) {
        return scoreRepository.save(score);
    }

    @DeleteMapping("/{id}")
    public void deleteScore(@PathVariable Long id) {
        scoreRepository.deleteById(id);
    }
}
