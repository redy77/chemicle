package com.chemcool.school.web.api.controllers;

import com.chemcool.school.domain.ChemistryLessonExample;
import com.chemcool.school.service.ChemistryLessonPageService;
import com.chemcool.school.web.api.dto.LessonExample;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/chemistry-lesson")
@RequiredArgsConstructor
public class ChemistryLessonRestController {

    private final ChemistryLessonPageService service;

    @PostMapping(value = "/create")
    @ApiOperation("Создает главу для сущность урока по химии.")
    @ResponseBody
    public String createLessonExample(
            @RequestBody LessonExample lessonExample
    ) {
        System.out.println("Hello World!");
        return service.manageLesson(new ChemistryLessonExample(
                lessonExample.getLessonExampleName(),
                lessonExample.getLessonExampleDescription(),
                lessonExample.getLessonExampleChapter(),
                lessonExample.getLessonExampleReferences()
        ));
    }




}
