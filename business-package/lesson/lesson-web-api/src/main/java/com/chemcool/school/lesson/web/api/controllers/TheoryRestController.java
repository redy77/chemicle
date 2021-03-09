package com.chemcool.school.lesson.web.api.controllers;

import com.chemcool.school.lesson.domain.ChemistryLesson;
import com.chemcool.school.lesson.theory.service.ChemistryTheoryPageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping({"/v1.0"})
@RequiredArgsConstructor
public class TheoryRestController {
    private final ChemistryTheoryPageService pageService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/findTaskAndTheoryByChapter")
    public ChemistryLesson findTaskAndTheoryByChapter(int chapter){
        return pageService.findTaskAndTheoryByChapter(chapter);
    }

    @GetMapping("/findTaskAndTheoryByReferences")
    public ChemistryLesson findTaskAndTheoryByReferences(int references){
        return pageService.findTaskAndTheoryByReferences(references);
    }

}
