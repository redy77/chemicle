package com.chemcool.school.lesson.web.api.controllers;

import com.chemcool.school.lesson.web.api.classForController.ChemTheoryDtoList;
import com.chemcool.school.lesson.web.api.dto.ChemTheoryDto;
import com.chemcool.school.lesson.web.api.service.ChemTheoryPresentation;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping({"/v1.0/theory"})
@RequiredArgsConstructor
public class TheoryRestController {
    private final ChemTheoryPresentation presentation;

    @ApiOperation("Возвращает все сущности теории")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ChemTheoryDtoList getAllTheory() {
        return ChemTheoryDtoList.getAllTheory(presentation);
    }

    @ApiOperation("Возвращает сущности теории по разделу")
    @GetMapping("/find-by-reference/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ChemTheoryDtoList findTheoryByReferenceId(@PathVariable("id") Integer referenceId) {
        return ChemTheoryDtoList.getTheoryByReference(presentation, referenceId);
    }

    @ApiOperation("Возвращает сущности теории по главе")
    @GetMapping("/find-by-chapter/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ChemTheoryDtoList findTheoryByChapter(@PathVariable("id") Integer chapterId) {
        return ChemTheoryDtoList.getTheoryByChapter(presentation, chapterId);
    }

    @ApiOperation("Возвращает сущности теории по разделу и главе")
    @GetMapping("/find-by-reference/{reference_id}/chapter/{chapter_id}")
    @ResponseStatus(HttpStatus.OK)
    public ChemTheoryDtoList findTheoryByReferenceIdAndChapterId(
            @PathVariable("reference_id") Integer referenceId,
            @PathVariable("chapter_id") Integer chapterId) {
        return ChemTheoryDtoList.getTaskByReferenceAndChapter(presentation, referenceId, chapterId);
    }

    @ApiOperation("Возвращает сущности теории по id")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ChemTheoryDto getTheoryExampleById(@PathVariable(name = "id") String id) {
        log.info("вызван контроллер для получения урока по id : " + "[" + id + "]");
        return presentation.getTheoryByIdDto(id);
    }

    @GetMapping("/random-task")
    @ApiOperation("Возвращает случайную сущность задания типа \"Уравнения\"")
    @ResponseStatus(HttpStatus.OK)
    public ChemTheoryDto getRandomTask() {
        return presentation.getRandomChemTheoryDto();
    }
}
