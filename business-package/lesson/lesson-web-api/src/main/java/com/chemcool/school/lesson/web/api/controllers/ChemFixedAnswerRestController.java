package com.chemcool.school.lesson.web.api.controllers;

import com.chemcool.school.lesson.tasks.chemfixedanswer.domain.ChemFixedAnswerTask;
import com.chemcool.school.lesson.tasks.chemfixedanswer.service.ChemFixedAnswerTaskProxyService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping({"/v1.0"})
@RequiredArgsConstructor
public class ChemFixedAnswerRestController {
    private final ChemFixedAnswerTaskProxyService taskService;

    @ApiOperation("Возвращает сущности задания типа \"Фиксированный ответ\" по разделу")
    @GetMapping("/findFixedAnswerTaskByReference")
    public List<ChemFixedAnswerTask> findTaskByReferences(int references){
        return taskService.getAllByReferenceId(references);
    }

    @ApiOperation("Возвращает сущности задания типа \"Фиксированный ответ\" по главе")
    @GetMapping("/findFixedAnswerTaskByChapter")
    public List<ChemFixedAnswerTask> findTaskByChapter(int chapter){
        return taskService.getAllByChapterId(chapter);
    }

    @ApiOperation("Возвращает сущности задания типа \"Фиксированный ответ\" по разделу и главе")
    @GetMapping("/findFixedAnswerTaskByReferenceAndChapter")
    public  List<ChemFixedAnswerTask> findTaskByReferenceIdAndChapterId(int referenceId, int chapterId){
        return taskService.getAllByReferenceIdAndChapterId(referenceId, chapterId);
    }
}
