package com.chemcool.school.lesson.web.api.controllers;

import com.chemcool.school.lesson.web.api.classForController.ChemFixedAnswerTaskDtoList;
import com.chemcool.school.lesson.web.api.dto.ChemFixedAnswerTaskDto;
import com.chemcool.school.lesson.web.api.service.ChemFixedAnswerTaskPresentation;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping({"/v1.0/chem-fixed-answer"})
@RequiredArgsConstructor
public class ChemFixedAnswerRestController {
    private final ChemFixedAnswerTaskPresentation presentation;

    @GetMapping
    @ApiOperation("Возвращает сущности задания типа \"Фиксированный ответ\" по химии")
    @ResponseStatus(HttpStatus.OK)
    public ChemFixedAnswerTaskDtoList getAll(){
        return ChemFixedAnswerTaskDtoList.getAllTask(presentation);
    }

    @ApiOperation("Возвращает сущности задания типа \"Фиксированный ответ\" по разделу")
    @GetMapping("/find-by-reference/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ChemFixedAnswerTaskDtoList findTaskByReferenceId(@PathVariable("id") Integer referenceId){
        return ChemFixedAnswerTaskDtoList.getTaskByReference(presentation, referenceId);
    }

    @ApiOperation("Возвращает сущности задания типа \"Фиксированный ответ\" по главе")
    @GetMapping("/find-by-chapter/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ChemFixedAnswerTaskDtoList findTaskByChapterId(@PathVariable("id") Integer chapterId){
        return ChemFixedAnswerTaskDtoList.getTaskByChapter(presentation, chapterId);
    }

    @ApiOperation("Возвращает сущности задания типа \"Фиксированный ответ\" по разделу и главе")
    @GetMapping("/find-by-reference/{reference_id}/chapter/{chapter_id}")
    @ResponseStatus(HttpStatus.OK)
    public  ChemFixedAnswerTaskDtoList findTaskByReferenceIdAndChapterId(
            @PathVariable("reference_id") Integer referenceId,
            @PathVariable("chapter_id") Integer chapterId) {
        return ChemFixedAnswerTaskDtoList.getTaskByReferenceAndChapter(presentation, referenceId, chapterId);
    }

    @GetMapping("/{id}")
    @ApiOperation("Возвращает задани по ID типа \"Фиксированный ответ\" по химии")
    @ResponseStatus(HttpStatus.OK)
    public ChemFixedAnswerTaskDto getFixedAnswerTaskById (@PathVariable String id){
        return presentation.getFixedAnswerTaskById(id);
    }

    @GetMapping("/random-task")
    @ApiOperation("Возвращает случайную сущность задания типа \"Уравнения\"")
    @ResponseStatus(HttpStatus.OK)
    public ChemFixedAnswerTaskDto getRandomTask() {
        return presentation.getRandomChemFixedAnswerTaskDto();
    }
}
