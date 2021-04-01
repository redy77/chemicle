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

    @ApiOperation("Find matches tasks by chapter")
    @GetMapping("/findMatchesByChapter")
    public List<ChemMatchingTask> findMatchesByChapter(int chapter){
        return taskService.getAllByChapterId(chapter);
    }

    @ApiOperation("Find matches tasks by references")
    @GetMapping("/findMatchesByReferences")
    public List<ChemMatchingTask> findMatchesByReferences(int references){
        return taskService.getAllByReferenceId(references);
    }
}
