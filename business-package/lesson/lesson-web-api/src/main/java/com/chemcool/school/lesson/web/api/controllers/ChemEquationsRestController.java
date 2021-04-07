package com.chemcool.school.lesson.web.api.controllers;

import com.chemcool.school.lesson.tasks.chemequations.domain.ChemEquationsTask;
import com.chemcool.school.lesson.tasks.chemequations.service.ChemEquationsTaskProxyService;
import com.chemcool.school.lesson.tasks.chemequations.service.ChemEquationsTaskService;
import com.chemcool.school.lesson.tasks.chemsingleselect.domain.ChemSingleSelectTask;
import com.chemcool.school.lesson.tasks.chemsingleselect.service.ChemSingleSelectTaskService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping({"/v1.0"})
@AllArgsConstructor
public class ChemEquationsRestController {

    private final ChemEquationsTaskProxyService taskService;

    @ApiOperation("Find equations tasks by chapter")
    @GetMapping("/findEquationsTaskByChapter")
    public List<ChemEquationsTask> findEquationsTaskByChapter(int chapter) {
        return taskService.getAllByChapterId(chapter);
    }

    @ApiOperation("Find equations tasks by references")
    @GetMapping("/findEquationsTaskByReferences")
    public List<ChemEquationsTask> findEquationsTaskByReferences(int references) {
        return taskService.getAllByReferenceId(references);
    }

}
