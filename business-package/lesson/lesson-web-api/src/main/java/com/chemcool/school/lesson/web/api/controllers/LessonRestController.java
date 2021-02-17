package com.chemcool.school.lesson.web.api.controllers;


/*
по номеру  главы и референса дает и теорию и задачу
 */

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

    @GetMapping("/getBy/{id}")
    public ChemistryLesson getTheoryExampleById(@PathVariable(name = "id") String id) {
        log.info("вызван контроллер для получения урока по id : " + "[" + id + "]");
        return presentation.getTheoryById(id);
    }

}

