package com.chemcool.school.lesson.web.api.controllers;

import com.chemcool.school.lesson.theory.domain.ChemTheory;
import com.chemcool.school.lesson.theory.service.ChemTheoryProxyService;
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
public class TheoryRestController {
    private final ChemTheoryProxyService pageService;

    @ApiOperation("Возвращает сущности теории по главе")
    @GetMapping("/findTheoryByChapterId")
    public List<ChemTheory> findTheoryByChapter(int chapterId){
        return pageService.getAllByChapterId(chapterId);
    }

    @ApiOperation("Возвращает сущности теории по разделу")
    @GetMapping("/findTheoryByReferenceId")
    public List<ChemTheory> findTheoryByReferenceId(int referenceId){
        return pageService.getAllByReferenceId(referenceId);
    }

    @ApiOperation("Возвращает сущности теории по разделу и главе")
    @GetMapping("/findTheoryByReferenceIdAndChapterId")
    public List<ChemTheory> findTheoryByReferenceIdAndChapterId(int referenceId, int chapterId){
        return pageService.getAllByReferenceIdAndChapterId(referenceId, chapterId);
    }
}
