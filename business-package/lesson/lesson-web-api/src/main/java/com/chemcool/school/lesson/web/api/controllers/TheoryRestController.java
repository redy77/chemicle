package com.chemcool.school.lesson.web.api.controllers;

import com.chemcool.school.lesson.theory.domain.ChemistryTheory;
import com.chemcool.school.lesson.theory.service.ChemistryTheoryPageService;
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
public class TheoryRestController {
    private final ChemistryTheoryPageService pageService;

    @GetMapping("/findTheoryByChapter")
    public List<ChemistryTheory> findTaskAndTheoryByChapter(int chapter){
        return pageService.findTheoryByChapter(chapter);
    }

    @GetMapping("/findTheoryByReferences")
    public List<ChemistryTheory> findTaskAndTheoryByReferences(int references){
        return pageService.findTheoryByReferences(references);
    }
}
