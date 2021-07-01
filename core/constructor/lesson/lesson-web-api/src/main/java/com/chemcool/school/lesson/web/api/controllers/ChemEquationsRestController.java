package com.chemcool.school.lesson.web.api.controllers;

import com.chemcool.school.lesson.web.api.classForController.ChemEquationsTaskDtoList;
import com.chemcool.school.lesson.web.api.dto.ChemEquationsTaskDto;
import com.chemcool.school.lesson.web.api.service.ChemEquationsTaskPresentation;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping({"/v1.0/chem-equations"})
@AllArgsConstructor
public class ChemEquationsRestController {

    private final ChemEquationsTaskPresentation presentation;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Возвращает все сущности задания типа \"Уравнения\"")
    public ChemEquationsTaskDtoList getAll() {
        return ChemEquationsTaskDtoList.getAllTask(presentation);
    }

    @ApiOperation("Возвращает сущности задания типа \"Уравнения\" по разделу")
    @GetMapping("/find-by-reference/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ChemEquationsTaskDtoList findTaskByReferenceId(@PathVariable("id") Integer referenceId) {
        return ChemEquationsTaskDtoList.getTaskByReference(presentation, referenceId);
    }

    @ApiOperation("Возвращает сущности задания типа \"Уравнения\" по главе")
    @GetMapping("/find-by-chapter/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ChemEquationsTaskDtoList findTaskByChapterId(@PathVariable("id") Integer chapterId) {
        return ChemEquationsTaskDtoList.getTaskByChapter(presentation, chapterId);
    }

    @ApiOperation("Возвращает сущности задания типа \"Уравнения\" по разделу и главе")
    @GetMapping("/find-by-reference/{reference_id}/chapter/{chapter_id}")
    @ResponseStatus(HttpStatus.OK)
    public ChemEquationsTaskDtoList findTaskByReferenceIdAndChapterId(
            @PathVariable("reference_id") Integer referenceId,
            @PathVariable("chapter_id") Integer chapterId) {
        return ChemEquationsTaskDtoList.getTaskByReferenceAndChapter(presentation, referenceId, chapterId);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Возвращает задание по ID типа \"Уравнения\"")
    public ChemEquationsTaskDto getEquationsTaskById(@PathVariable String id) {
        return presentation.getEquationsTaskById(id);
    }

    @GetMapping("/random-task")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Возвращает случайную сущность задания типа \"Уравнения\"")
    public ChemEquationsTaskDto getRandomTask() {
        return presentation.getRandomChemistryEquationsDto();
    }
}
