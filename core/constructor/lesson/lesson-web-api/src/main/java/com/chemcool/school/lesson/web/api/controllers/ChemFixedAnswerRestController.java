package com.chemcool.school.lesson.web.api.controllers;

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
@RequestMapping({"chemFixedAnswer/v1.0"})
@RequiredArgsConstructor
public class ChemFixedAnswerRestController {
    private final ChemFixedAnswerTaskPresentation presentation;

    @GetMapping
    @ApiOperation("Возвращает сущности задания типа \"Фиксированный ответ\" по химии")
    @ResponseStatus(HttpStatus.OK)
    public List<ChemFixedAnswerTaskDto> getAll(){
        return presentation.getAllChemistryFixedAnswerDto();
    }

    @ApiOperation("Возвращает сущности задания типа \"Фиксированный ответ\" по разделу")
    @GetMapping("/findFixedAnswerTaskByReferenceId/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<ChemFixedAnswerTaskDto> findTaskByReferenceId(@PathVariable("id") Integer referenceId){
        return presentation.getAllChemistryFixedAnswerByReferenceIdDto(referenceId);
    }

    @ApiOperation("Возвращает сущности задания типа \"Фиксированный ответ\" по главе")
    @GetMapping("/findFixedAnswerTaskByChapterId/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<ChemFixedAnswerTaskDto> findTaskByChapterId(@PathVariable("id") Integer chapterId){
        return presentation.getAllChemistryFixedAnswerByChapterIdDto(chapterId);
    }

    @ApiOperation("Возвращает сущности задания типа \"Фиксированный ответ\" по разделу и главе")
    @GetMapping("/findFixedAnswerTaskByReferenceId/{reference_id}/AndChapterId/{chapter_id}")
    @ResponseStatus(HttpStatus.OK)
    public  List<ChemFixedAnswerTaskDto> findTaskByReferenceIdAndChapterId(
            @PathVariable("reference_id") Integer referenceId,
            @PathVariable("chapter_id") Integer chapterId) {
        return presentation.getAllChemistryFixedAnswerByReferenceIdAndChapterIdDto(referenceId, chapterId);
    }

    @GetMapping("/{id}")
    @ApiOperation("Возвращает задани по ID типа \"Фиксированный ответ\" по химии")
    @ResponseStatus(HttpStatus.OK)
    public ChemFixedAnswerTaskDto getFixedAnswerTaskById (@PathVariable String id){
        return presentation.getFixedAnswerTaskById(id);
    }

    @GetMapping("/randomTask")
    @ApiOperation("Возвращает случайную сущность задания типа \"Уравнения\"")
    @ResponseStatus(HttpStatus.OK)
    public ChemFixedAnswerTaskDto getRandomTask() {
        return presentation.getRandomChemFixedAnswerTaskDto();
    }
}
