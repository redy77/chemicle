package com.chemcool.school.lesson.web.api.controllers;

import com.chemcool.school.lesson.tasks.chemfixedanswer.domain.ChemFixedAnswerTask;
import com.chemcool.school.lesson.tasks.chemfixedanswer.service.ChemFixedAnswerTaskService;
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
    private final ChemFixedAnswerTaskService taskService;

    @ApiOperation("Find fixed answer tasks by chapter")
    @GetMapping("/findFixedAnswerTaskByChapter")
    public List<ChemFixedAnswerTask> findFixedAnswerTaskByChapter(int chapter){
        return taskService.getTaskByChapter(chapter);
    }

    @ApiOperation("Find fixed answer tasks by references")
    @GetMapping("/findFixedAnswerTaskByReferences")
    public List<ChemFixedAnswerTask> findFixedAnswerTaskByReferences(int references){
        return taskService.getTaskByReferences(references);
    }
}
