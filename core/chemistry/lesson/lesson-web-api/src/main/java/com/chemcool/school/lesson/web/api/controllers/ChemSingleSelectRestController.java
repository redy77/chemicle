package com.chemcool.school.lesson.web.api.controllers;

import com.chemcool.school.lesson.web.api.classForController.ChemSingleSelectTaskDtoList;
import com.chemcool.school.lesson.web.api.dto.ChemSingleSelectTaskDto;
import com.chemcool.school.lesson.web.api.service.ChemSingleSelectTaskPresentation;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping({"/v1.0/chem-single-select"})
@RequiredArgsConstructor
public class ChemSingleSelectRestController {
    private final ChemSingleSelectTaskPresentation presentation;

    @GetMapping
    @ApiOperation("Возвращает все задания типа \"Выбор одного ответа\" по химии.")
    @ResponseStatus(HttpStatus.OK)
    public ChemSingleSelectTaskDtoList getAllTasks() {
        return ChemSingleSelectTaskDtoList.getAllTask(presentation);
    }

    @ApiOperation("Возвращает сущности задания типа \"Один ответ\" по разделу")
    @GetMapping("/find-by-reference/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ChemSingleSelectTaskDtoList findTaskByReferenceId(@PathVariable("id") Integer referenceId){
        return ChemSingleSelectTaskDtoList.getTaskByReference(presentation, referenceId);
    }

    @ApiOperation("Возвращает сущности задания типа \"Один ответ\" по главе")
    @GetMapping("/find-by-chapter/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ChemSingleSelectTaskDtoList findTaskByChapterId(@PathVariable("id") Integer chapterId){
        return ChemSingleSelectTaskDtoList.getTaskByChapter(presentation, chapterId);
    }

    @ApiOperation("Возвращает сущности задания типа \"Один ответ\" по разделу и главе")
    @GetMapping("/find-by-reference/{reference_id}/chapter/{chapter_id}")
    @ResponseStatus(HttpStatus.OK)
    public ChemSingleSelectTaskDtoList findTaskByReferenceIdAndChapterId(
            @PathVariable("reference_id") Integer referenceId,
            @PathVariable("chapter_id") Integer chapterId) {
        return ChemSingleSelectTaskDtoList.getTaskByReferenceAndChapter(presentation, referenceId, chapterId);
    }

    @GetMapping("/{uuid}")
    @ApiOperation("Возвращает дто сущности задания типа \"Выбор одного ответа\" по химии по UUID.")
    @ResponseStatus(HttpStatus.OK)
    public ChemSingleSelectTaskDto getTaskById(@PathVariable String uuid) {
        return presentation.getTaskDtoByIdDto(uuid);
    }

    @GetMapping("/random-task")
    @ApiOperation("Возвращает случайную сущность задания типа \"Уравнения\"")
    @ResponseStatus(HttpStatus.OK)
    public ChemSingleSelectTaskDto getRandomTask() {
        return presentation.getRandomChemSingleSelectTaskDto();
    }
}
