package com.chemcool.school.lesson.web.api.controllers;

import com.chemcool.school.lesson.web.api.classForController.ChemMatchingTaskDtoList;
import com.chemcool.school.lesson.web.api.dto.ChemMatchingTaskDto;
import com.chemcool.school.lesson.web.api.service.ChemMatchingTaskPresentation;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping({"/v1.0/chem-matches"})
@RequiredArgsConstructor
public class ChemMatchesRestController {
    private final ChemMatchingTaskPresentation presentation;

    @GetMapping
    @ApiOperation("Возвращает все задания типа \"matching(сопоставления)\" по химии.")
    @ResponseStatus(HttpStatus.OK)
    public ChemMatchingTaskDtoList getAllTasks(){
        return ChemMatchingTaskDtoList.getAllTask(presentation);
    }

    @ApiOperation("Возвращает сущности задания типа \"Сопоставление\" по разделу")
    @GetMapping("/find-by-reference/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ChemMatchingTaskDtoList findTaskByReferences(@PathVariable("id") Integer referenceId){
        return ChemMatchingTaskDtoList.getTaskByReference(presentation, referenceId);
    }

    @ApiOperation("Возвращает сущности задания типа \"Сопоставление\" по главе")
    @GetMapping("/find-by-chapter/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ChemMatchingTaskDtoList findTaskByChapter(@PathVariable("id") Integer chapterId){
        return ChemMatchingTaskDtoList.getTaskByChapter(presentation, chapterId);
    }

    @ApiOperation("Возвращает сущности задания типа \"Сопоставление\" по разделу и главе")
    @GetMapping("/find-by-reference/{reference_id}/chapter/{chapter_id}")
    @ResponseStatus(HttpStatus.OK)
    public ChemMatchingTaskDtoList findTaskByReferenceIdAndChapterId(
            @PathVariable("reference_id") Integer referenceId,
            @PathVariable("chapter_id") Integer chapterId){
        return ChemMatchingTaskDtoList.getTaskByReferenceAndChapter(presentation, referenceId, chapterId);
    }

    @GetMapping("/{uuid}")
    @ApiOperation("Возвращает дто сущности задания типа \"matching(сопоставления)\" по химии по UUID.")
    @ResponseStatus(HttpStatus.OK)
    public ChemMatchingTaskDto getTaskById(@PathVariable String uuid){
        return presentation.getTaskDtoById(uuid);
    }

    @GetMapping("/random-task")
    @ApiOperation("Возвращает случайную сущность задания типа \"Уравнения\"")
    @ResponseStatus(HttpStatus.OK)
    public ChemMatchingTaskDto getRandomTask() {
        return presentation.getRandomChemMatchingTaskDto();
    }
}
