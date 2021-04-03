package com.chemcool.school.lesson.web.api.controllers;

import com.chemcool.school.lesson.tasks.chemequations.domain.ChemEquationsTask;
import com.chemcool.school.lesson.tasks.chemequations.service.ChemEquationsTaskProxyService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping({"/v1.0"})
@AllArgsConstructor
public class ChemEquationsRestController {

    private final ChemEquationsTaskProxyService taskService;

    @ApiOperation("Возвращает сущности задания типа \"Уравнения\" по разделу")
    @GetMapping("/findEquationsTaskByReferenceId")
    @ResponseStatus(HttpStatus.OK)
    public List<ChemEquationsTask> findTaskByReferenceId(int referenceId) {
        return taskService.getAllByReferenceId(referenceId);
    }

    @ApiOperation("Возвращает сущности задания типа \"Уравнения\" по главе")
    @GetMapping("/findEquationsTaskByChapterId")
    @ResponseStatus(HttpStatus.OK)
    public List<ChemEquationsTask> findTaskByChapterId(int chapterId) {
        return taskService.getAllByChapterId(chapterId);
    }

    @ApiOperation("Возвращает сущности задания типа \"Уравнения\" по разделу и главе")
    @GetMapping("/findEquationsTaskByReferenceIdAndChapterId")
    @ResponseStatus(HttpStatus.OK)
    public List<ChemEquationsTask> findTaskByReferenceIdAndChapterId(int referenceId, int chapterId) {
        return taskService.getAllByReferenceIdAndChapterId(referenceId, chapterId);
    }
}
