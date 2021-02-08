package com.chemcool.school.theory.web.api.controllers;

import com.chemcool.school.theory.domain.ChemistryTheory;
import com.chemcool.school.theory.web.api.dto.TheoryDto;
import com.chemcool.school.theory.web.api.service.ChemistryTheoryPresentation;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping({"/v1.0/lessons"})
@RequiredArgsConstructor
public class ChemistryTheoryRestController {

    private final ChemistryTheoryPresentation presentation;

    @PostMapping(value = "/create")
    @ApiOperation("Создает главу для сущность урока по химии.")
    @ResponseBody
    public String createLessonExample(
            @RequestBody TheoryDto theoryDto
    ) {
        log.info("Вызван контроллер для добавления новой темы с названием: " + "[" + theoryDto.getTheoryName() + "]");
        return presentation.createChemistryTheoryDto(theoryDto);
    }

    @PutMapping(value = "/update")
    @ResponseBody
    public void updateLessonExample(
         //   @RequestParam String lessonExampleId,
            @RequestBody TheoryDto dto
    ) {
        log.info("Вызван контроллер для изменения темы с названием: " + "[" + dto.getTheoryName() + "]");
        presentation.updateChemistryTheoryDto(dto);
        //return presentation.updateChemistryTheoryExample(lessonExampleId, dto);
    }

    @DeleteMapping(value = "/delete")
    @ResponseBody
    public void deleteLessonExample(
            @RequestBody TheoryDto theoryDto
    ) {
        log.info("Вызван контроллер для удаления темы с названием: " + "[" + theoryDto.getTheoryName() + "]");
        presentation.deleteChemistryTheoryDto(theoryDto);
        // presentation.deleteChemistryTheoryExample(theoryDto);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }


    @GetMapping("/getBy/{id}")
    public ChemistryTheory getTheoryExampleById(@PathVariable(name = "id") String id) {
        log.info("вызван контроллер для получения урока по id : " + "[" + id + "]");
        return presentation.getTheoryById(id);
    }
}
