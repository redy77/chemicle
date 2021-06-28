package com.chemcool.school.lesson.web.api.controllers;

import com.chemcool.school.lesson.web.api.dto.ChemSingleSelectTaskDto;
import com.chemcool.school.lesson.web.api.dto.ChemTheoryDto;
import com.chemcool.school.lesson.web.api.service.ChemTheoryPresentation;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping({"theory/v1.0"})
@RequiredArgsConstructor
public class TheoryRestController {
    private final ChemTheoryPresentation presentation;

    @ApiOperation("Возвращает все сущности теории")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ChemTheoryDto> getAllTheory() {
        return presentation.getAllTheoryDto();
    }

    @ApiOperation("Возвращает сущности теории по главе")
    @GetMapping("/findTheoryByChapterId/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<ChemTheoryDto> findTheoryByChapter(@PathVariable("id") Integer chapterId) {
        return presentation.getAllTheoryByChapterIdDto(chapterId);
    }

    @ApiOperation("Возвращает сущности теории по разделу")
    @GetMapping("/findTheoryByReferenceId/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<ChemTheoryDto> findTheoryByReferenceId(@PathVariable("id") Integer referenceId) {
        return presentation.getAllTheoryByReferenceIdDto(referenceId);
    }

    @ApiOperation("Возвращает сущности теории по разделу и главе")
    @GetMapping("/findTheoryByReferenceId/{reference_id}/AndChapterId/{chapter_id}")
    @ResponseStatus(HttpStatus.OK)
    public List<ChemTheoryDto> findTheoryByReferenceIdAndChapterId(
            @PathVariable("reference_id") Integer referenceId,
            @PathVariable("chapter_id") Integer chapterId) {
        return presentation.getAllTheoryByReferenceIdAndChapterIdDto(referenceId, chapterId);
    }

    @ApiOperation("Возвращает сущности теории по id")
    @GetMapping("/getBy/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ChemTheoryDto getTheoryExampleById(@PathVariable(name = "id") String id) {
        log.info("вызван контроллер для получения урока по id : " + "[" + id + "]");
        return presentation.getTheoryByIdDto(id);
    }

    @GetMapping("/randomTask")
    @ApiOperation("Возвращает случайную сущность задания типа \"Уравнения\"")
    @ResponseStatus(HttpStatus.OK)
    public ChemTheoryDto getRandomTask() {
        return presentation.getRandomChemTheoryDto();
    }
}
