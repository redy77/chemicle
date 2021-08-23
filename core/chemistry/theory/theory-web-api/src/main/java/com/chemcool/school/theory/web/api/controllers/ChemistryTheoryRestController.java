package com.chemcool.school.theory.web.api.controllers;

import com.chemcool.school.theory.web.api.dto.TheoryDto;
import com.chemcool.school.theory.web.api.service.ChemistryTheoryPresentation;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping({"/theory/v1.0"})
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
    @ApiOperation("Обновляет главу для сущность урока по химии.")
    @ResponseBody
    public void updateLessonExample(
            @RequestBody TheoryDto dto
    ) {
        log.info("Вызван контроллер для изменения темы с названием: " + "[" + dto.getTheoryName() + "]");
        presentation.updateChemistryTheoryDto(dto);
    }

    @DeleteMapping(value = "/delete")
    @ApiOperation("Удаляет главу для сущность урока по химии.")
    @ResponseBody
    public void deleteLessonExample(@RequestBody TheoryDto theoryDto) {
        log.info("Вызван контроллер для удаления темы с названием: " + "[" + theoryDto.getTheoryName() + "]");
        presentation.deleteChemistryTheoryDto(theoryDto);
    }
}
