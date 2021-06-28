package com.chemcool.school.lesson.web.api.controllers;

import com.chemcool.school.lesson.web.api.dto.ChemEquationsTaskDto;
import com.chemcool.school.lesson.web.api.service.ChemEquationsTaskPresentation;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping({"chemEquations/v1.0"})
@AllArgsConstructor
public class ChemEquationsRestController {

    private final ChemEquationsTaskPresentation presentation;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Возвращает все сущности задания типа \"Уравнения\"")
    public List<ChemEquationsTaskDto> getAll() {
        return presentation.getAllChemistryEquationsDto();
    }

    @ApiOperation("Возвращает сущности задания типа \"Уравнения\" по разделу")
    @GetMapping("/findEquationsTaskByReferenceId/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<ChemEquationsTaskDto> findTaskByReferenceId(@PathVariable("id") Integer referenceId) {
        return presentation.getAllChemistryEquationsByReferenceIdDto(referenceId);
    }

    @ApiOperation("Возвращает сущности задания типа \"Уравнения\" по главе")
    @GetMapping("/findEquationsTaskByChapterId/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<ChemEquationsTaskDto> findTaskByChapterId(@PathVariable("id") Integer chapterId) {
        return presentation.getAllChemistryEquationsByChapterIdDto(chapterId);
    }

    @ApiOperation("Возвращает сущности задания типа \"Уравнения\" по разделу и главе")
    @GetMapping("/findEquationsTaskByReferenceId/{reference_id}/AndChapterId/{chapter_id}")
    @ResponseStatus(HttpStatus.OK)
    public List<ChemEquationsTaskDto> findTaskByReferenceIdAndChapterId(
            @PathVariable("reference_id") Integer referenceId,
            @PathVariable("chapter_id") Integer chapterId) {
        return presentation.getAllChemistryEquationsByReferenceIdAndChapterIdDto(referenceId, chapterId);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Возвращает задание по ID типа \"Уравнения\"")
    public ChemEquationsTaskDto getEquationsTaskById(@PathVariable String id) {
        return presentation.getEquationsTaskById(id);
    }

    @GetMapping("/randomTask")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Возвращает случайную сущность задания типа \"Уравнения\"")
    public ChemEquationsTaskDto getRandomTask() {
        return presentation.getRandomChemistryEquationsDto();
    }
}
