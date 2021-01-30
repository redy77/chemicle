package com.chemcool.school.theory.web.api.controllers;

import com.chemcool.school.theory.domain.ChemistryLesson;
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

    @PutMapping(value = "/update")
    @ResponseBody
    public String updateLessonExample(
            @RequestParam String lessonExampleId,
            @RequestBody LessonExample example
    ) {
        log.info("Вызван контроллер для изменения темы с названием: " + "[" + example.getLessonExampleName() + "]");
        return presentation.updateChemistryLessonExample(lessonExampleId, example);
    }

    @DeleteMapping(value = "/delete")
    @ResponseBody
    public void deleteLessonExample(
            @RequestBody LessonExample lessonExample
    ) {
        log.info("Вызван контроллер для удаления темы с названием: " + "[" + lessonExample.getLessonExampleName() + "]");
        presentation.deleteChemistryLessonExample(lessonExample);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }


    @GetMapping("/getBy/{id}")
    public ChemistryLesson getLessonExampleById(@PathVariable(name = "id") String id) {
        log.info("вызван контроллер для получения урока по id : " + "[" + id + "]");
        return presentation.getLessonById(id);
    }
}
