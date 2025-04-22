package com.luv2code.lms.controller;
import com.luv2code.lms.model.Lesson;
import com.luv2code.lms.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {

    private final LessonRepository lessonRepository;

    @Autowired
    public LessonController(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @GetMapping
    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll();
    }

    @GetMapping("/{courseId}")
    public List<Lesson> getLessonsByCourseId(@PathVariable Long courseId) {
        return lessonRepository.findByCourseId(courseId);
    }

    @PostMapping
    public Lesson createLesson(@RequestBody Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    @PutMapping("/{id}")
    public Lesson updateLesson(@PathVariable Long id, @RequestBody Lesson lesson) {
        lesson.setId(id);
        return lessonRepository.save(lesson);
    }

    @DeleteMapping("/{id}")
    public void deleteLesson(@PathVariable Long id) {
        lessonRepository.deleteById(id);
    }
}
