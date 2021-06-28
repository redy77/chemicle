package com.chemcool.school.lesson.web.api.controllers;

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
@RequestMapping({"chemMatches/v1.0"})
@RequiredArgsConstructor
public class ChemMatchesRestController {
    private final ChemMatchingTaskPresentation presentation;

    @GetMapping
    @ApiOperation("Возвращает все задания типа \"matching(сопоставления)\" по химии.")
    @ResponseStatus(HttpStatus.OK)
    public List<ChemMatchingTaskDto> getAllTasks(){
        return presentation.getAllTasks();
    }

    @ApiOperation("Возвращает сущности задания типа \"Сопоставление\" по разделу")
    @GetMapping("/findMatchesTaskByReferenceId/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<ChemMatchingTaskDto> findTaskByReferences(@PathVariable("id") Integer referenceId){
        return presentation.getAllTasksByReferenceIdDto(referenceId);
    }

    @ApiOperation("Возвращает сущности задания типа \"Сопоставление\" по главе")
    @GetMapping("/findMatchesTaskByChapterId/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<ChemMatchingTaskDto> findTaskByChapter(@PathVariable("id") Integer chapterId){
        return presentation.getAllTasksByChapterIdDto(chapterId);
    }

    @ApiOperation("Возвращает сущности задания типа \"Сопоставление\" по разделу и главе")
    @GetMapping("/findMatchesTaskByReferenceId/{reference_id}/AndChapterId/{chapter_id}")
    @ResponseStatus(HttpStatus.OK)
    public List<ChemMatchingTaskDto> findTaskByReferenceIdAndChapterId(
            @PathVariable("reference_id") Integer referenceId,
            @PathVariable("chapter_id") Integer chapterId){
        return presentation.getAllTasksByReferenceIdAndChapterIdDto(referenceId, chapterId);
    }

    @GetMapping("/{uuid}")
    @ApiOperation("Возвращает дто сущности задания типа \"matching(сопоставления)\" по химии по UUID.")
    @ResponseStatus(HttpStatus.OK)
    public ChemMatchingTaskDto getTaskById(@PathVariable String uuid){
        return presentation.getTaskDtoById(uuid);
    }

    @GetMapping("/randomTask")
    @ApiOperation("Возвращает случайную сущность задания типа \"Уравнения\"")
    @ResponseStatus(HttpStatus.OK)
    public ChemMatchingTaskDto getRandomTask() {
        return presentation.getRandomChemMatchingTaskDto();
    }
}
