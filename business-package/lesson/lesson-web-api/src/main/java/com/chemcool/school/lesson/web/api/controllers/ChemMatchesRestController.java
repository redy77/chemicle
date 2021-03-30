package com.chemcool.school.lesson.web.api.controllers;



import com.chemcool.school.lesson.tasks.chemmatches.domain.ChemistryMatchingTask;
import com.chemcool.school.lesson.tasks.chemmatches.service.ChemistryMatchingTaskProxyService;
import com.chemcool.school.lesson.tasks.chemmatches.service.ChemistryMatchingTaskService;
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
    private final ChemistryMatchingTaskProxyService taskService;

    @ApiOperation("Find matches tasks by chapter")
    @GetMapping("/findMatchesByChapter")
    public List<ChemistryMatchingTask> findMatchesByChapter(int chapter){
        return taskService.getAllByChapterId(chapter);
    }

    @ApiOperation("Find matches tasks by references")
    @GetMapping("/findMatchesByReferences")
    public List<ChemistryMatchingTask> findMatchesByReferences(int references){
        return taskService.getAllByReferenceId(references);
    }
}
