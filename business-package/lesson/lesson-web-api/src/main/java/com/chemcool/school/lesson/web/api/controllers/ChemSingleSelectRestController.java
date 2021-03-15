package com.chemcool.school.lesson.web.api.controllers;

import com.chemcool.school.lesson.tasks.chemsingleselect.domain.ChemSingleSelectTask;
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
    private final ChemSingleSelectTaskService taskService;

//    @GetMapping("/hello")
//    public String hello() {
//        return "Hello World!";
//    }

    @GetMapping("/findTaskByChapter")
    public List<ChemSingleSelectTask> findTaskByChapter(int chapter){
        return taskService.findTaskByChapter(chapter);
    }

    @GetMapping("/findTaskByReferences")
    public List<ChemSingleSelectTask> findTaskByReferences(int references){
        return taskService.findTaskByReferences(references);
    }
}
