package com.chemcool.school.lesson.web.api.controllers;

import com.chemcool.school.lesson.web.api.classForController.LessonDtoList;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping({"/v1.0/lesson"})
@AllArgsConstructor
public class LessonRestController {
    private final LessonDtoList lessonDtoList;


    @ApiOperation("Возвращает сущности заданий и теории по разделу")
    @GetMapping("/get-by-reference/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LessonDtoList findLessonByReferenceId(@PathVariable("id") Integer referenceId) {
        return lessonDtoList.getLessonByReference(referenceId);
    }

    @ApiOperation("Возвращает сущности заданий и теории по главе")
    @GetMapping("/get-by-chapter/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LessonDtoList findLessonByChapterId(@PathVariable("id") Integer chapterId) {
        return lessonDtoList.getLessonByChapter(chapterId);
    }

    @ApiOperation("Возвращает сущности заданий и теории по разделу и главе")
    @GetMapping("/get-by-reference/{chapter_id}/chapter/{reference_id}")
    @ResponseStatus(HttpStatus.OK)
    public LessonDtoList findLessonReferenceIdAndByChapterId(
            @PathVariable("chapter_id") Integer chapterId,
            @PathVariable("reference_id") Integer referenceId) {
        return lessonDtoList.getLessonByReferenceAndChapter(referenceId, chapterId);
    }
}
