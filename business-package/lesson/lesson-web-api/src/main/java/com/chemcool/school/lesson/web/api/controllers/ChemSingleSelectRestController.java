package com.chemcool.school.lesson.web.api.controllers;

import com.chemcool.school.lesson.tasks.chemsingleselect.domain.ChemSingleSelectTask;
import com.chemcool.school.lesson.tasks.chemsingleselect.service.ChemSingleSelectTaskProxyService;
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
public class ChemSingleSelectRestController {
    private final ChemSingleSelectTaskProxyService taskService;

    @ApiOperation("Возвращает сущности задания типа \"Один ответ\" по главе")
    @GetMapping("/findSingleSelectTaskByChapterId")
    public List<ChemSingleSelectTask> findTaskByChapterId(int chapterId){
        return taskService.getAllByChapterId(chapterId);
    }

    @ApiOperation("Возвращает сущности задания типа \"Один ответ\" по разделу")
    @GetMapping("/findSingleSelectTaskByReferenceId")
    public List<ChemSingleSelectTask> findTaskByReferenceId(int referenceId){
        return taskService.getAllByReferenceId(referenceId);
    }

    @ApiOperation("Возвращает сущности задания типа \"Один ответ\" по разделу и главе")
    @GetMapping("/findSingleSelectTaskByReferenceIdAndChapterId")
    public List<ChemSingleSelectTask> findTaskByReferenceIdAndChapterId(int referenceId, int chapterId){
        return taskService.getAllByReferenceIdAndChapterId(referenceId, chapterId);
    }
}
