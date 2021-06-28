package com.chemcool.school.lesson.web.api.controllers;


import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping({"lesson/v1.0"})
@AllArgsConstructor
public class LessonRestController {

    private final TheoryRestController theoryRestController;
    private final ChemEquationsRestController chemEquationsRestController;
    private final ChemFixedAnswerRestController chemFixedAnswerRestController;
    private final ChemMatchesRestController matchesRestController;
    private final ChemSingleSelectRestController chemSingleSelectRestController;


    @ApiOperation("Возвращает сущности заданий и теории по разделу")
    @GetMapping("/getLessonByReferenceId/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List[] findLessonByReferenceId(@PathVariable("id") int referenceId) {
        return new List[]{
                theoryRestController.findTheoryByReferenceId(referenceId),
                chemEquationsRestController.findTaskByReferenceId(referenceId),
                chemFixedAnswerRestController.findTaskByReferenceId(referenceId),
                matchesRestController.findTaskByReferences(referenceId),
                chemSingleSelectRestController.findTaskByReferenceId(referenceId)
        };
    }

    @ApiOperation("Возвращает сущности заданий и теории по главе")
    @GetMapping("/getLessonByChapterId/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List[] findLessonByChapterId(@PathVariable("id") int chapterId) {
        return new List[]{
                theoryRestController.findTheoryByChapter(chapterId),
                chemEquationsRestController.findTaskByChapterId(chapterId),
                chemFixedAnswerRestController.findTaskByChapterId(chapterId),
                matchesRestController.findTaskByChapter(chapterId),
                chemSingleSelectRestController.findTaskByChapterId(chapterId)
        };
    }

    @ApiOperation("Возвращает сущности заданий и теории по разделу и главе")
    @GetMapping("/getLessonByReferenceId/{chapter_id}/AndChapterId/{reference_id}")
    @ResponseStatus(HttpStatus.OK)
    public List[] findLessonReferenceIdAndByChapterId(
            @PathVariable("chapter_id") int chapterId,
            @PathVariable("reference_id") int referenceId) {
        return new List[]{
                theoryRestController.findTheoryByReferenceIdAndChapterId(chapterId, referenceId),
                chemEquationsRestController.findTaskByReferenceIdAndChapterId(chapterId, referenceId),
                chemFixedAnswerRestController.findTaskByReferenceIdAndChapterId(chapterId, referenceId),
                matchesRestController.findTaskByReferenceIdAndChapterId(chapterId, referenceId),
                chemSingleSelectRestController.findTaskByReferenceIdAndChapterId(chapterId, referenceId)
        };
    }
}
