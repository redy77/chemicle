package com.chemcool.school.lesson.web.api.controllers;

import com.chemcool.school.lesson.theory.domain.ChemTheory;
import com.chemcool.school.lesson.theory.service.ChemistryTheoryProxyService;
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
    private final ChemistryTheoryProxyService pageService;

    @GetMapping("/findTheoryByChapter")
    public List<ChemTheory> findTaskAndTheoryByChapter(int chapterId){
        return pageService.getAllByChapterId(chapterId);
    }

    @GetMapping("/findTheoryByReferences")
    public List<ChemTheory> findTaskAndTheoryByReferences(int referenceId){
        return pageService.getAllByReferenceId(referenceId);
    }
}
