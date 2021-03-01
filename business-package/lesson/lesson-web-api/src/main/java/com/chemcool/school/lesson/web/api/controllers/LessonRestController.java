package com.chemcool.school.lesson.web.api.controllers;


/*
по номеру  главы и референса дает и теорию и задачу
 */

import com.chemcool.school.lesson.domain.ChemistryLesson;
import com.chemcool.school.lesson.web.api.service.ChemistryLessonPresentation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping({"/v1.0/lessons"})
@RequiredArgsConstructor
public class LessonRestController {

    private final ChemistryLessonPresentation presentation;



    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/findTaskAndTheoryByChapter")
    public ChemistryLesson findTaskAndTheoryByChapter(int chapter){
        return presentation.findTaskAndTheoryByChapter(chapter);
    }

    @GetMapping("/findTaskAndTheoryByReferences")
    public ChemistryLesson findTaskAndTheoryByReferences(int references){
        return presentation.findTaskAndTheoryByReferences(references);
    }

}

