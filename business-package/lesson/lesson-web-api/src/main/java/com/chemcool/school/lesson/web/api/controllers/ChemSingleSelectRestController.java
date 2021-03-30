package com.chemcool.school.lesson.web.api.controllers;

import com.chemcool.school.lesson.tasks.chemsingleselect.domain.ChemSingleSelectTask;
import com.chemcool.school.lesson.tasks.chemsingleselect.service.ChemSingleSelectTaskProxyService;
import com.chemcool.school.lesson.tasks.chemsingleselect.service.ChemSingleSelectTaskService;
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

    @GetMapping("/findSingleSelectTaskByChapter")
    public List<ChemSingleSelectTask> findTaskByChapter(int chapter){
        return taskService.getAllByChapterId(chapter);
    }

    @GetMapping("/findSingleSelectTaskByReferences")
    public List<ChemSingleSelectTask> findTaskByReferences(int references){
        return taskService.getAllByReferenceId(references);
    }
}
