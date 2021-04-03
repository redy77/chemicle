package com.chemcool.school.lesson.web.api.controllers;



import com.chemcool.school.lesson.tasks.chemmatches.domain.ChemMatchingTask;
import com.chemcool.school.lesson.tasks.chemmatches.service.ChemMatchingTaskProxyService;
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
public class ChemMatchesRestController {
    private final ChemMatchingTaskProxyService taskService;

    @ApiOperation("Возвращает сущности задания типа \"Сопоставление\" по разделу")
    @GetMapping("/findMatchesTaskByReferenceId")
    public List<ChemMatchingTask> findTaskByReferences(int referenceId){
        return taskService.getAllByReferenceId(referenceId);
    }

    @ApiOperation("Возвращает сущности задания типа \"Сопоставление\" по главе")
    @GetMapping("/findMatchesTaskByChapterId")
    public List<ChemMatchingTask> findTaskByChapter(int chapterId){
        return taskService.getAllByChapterId(chapterId);
    }

    @ApiOperation("Возвращает сущности задания типа \"Сопоставление\" по разделу и главе")
    @GetMapping("/findMatchesTaskByReferenceIdAndChapterId")
    public List<ChemMatchingTask> findTaskByReferenceIdAndChapterId(int referenceId, int chapterId){
        return taskService.getAllByReferenceIdAndChapterId(referenceId, chapterId);
    }
}
