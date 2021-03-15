package com.chemcool.school.lesson.web.api.controllers;

import com.chemcool.school.lesson.tasks.chemequations.domain.ChemEquationsTask;
import com.chemcool.school.lesson.tasks.chemequations.service.ChemEquationsTaskService;
import com.chemcool.school.lesson.tasks.chemsingleselect.domain.ChemSingleSelectTask;
import com.chemcool.school.lesson.tasks.chemsingleselect.service.ChemSingleSelectTaskService;
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
public class ChemEquationsRestController {
    private final ChemEquationsTaskService taskService;

    @ApiOperation("Find equations tasks by chapter")
    @GetMapping("/findEquationsTaskByChapter")
    public List<ChemEquationsTask> findEquationsTaskByChapter(int chapter){
        return taskService.findTaskByChapter(chapter);
    }

    @ApiOperation("Find equations tasks by references")
    @GetMapping("/findEquationsTaskByReferences")
    public List<ChemEquationsTask> findEquationsTaskByReferences(int references){
        return taskService.findTaskByReferences(references);
    }
}
