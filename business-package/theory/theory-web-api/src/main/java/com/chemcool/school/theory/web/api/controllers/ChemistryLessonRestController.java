package com.chemcool.school.theory.web.api.controllers;

import com.chemcool.school.theory.web.api.dto.LessonExample;
import com.chemcool.school.theory.web.api.service.ChemistryLessonPresentation;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping({"/v1.0/lessons"})
@RequiredArgsConstructor
public class ChemistryLessonRestController {

    private final ChemistryLessonPresentation presentation;

    @PostMapping(value = "/create")
    @ApiOperation("Создает главу для сущность урока по химии.")
    @ResponseBody
    public String createLessonExample(
            @RequestBody LessonExample lessonExample
    ) {
        log.info("Вызван контроллер для добавления новой темы с названием: " + "[" + lessonExample.getLessonExampleName() + "]");
        return presentation.createChemistryLessonExample(lessonExample);
    }


    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }



}
