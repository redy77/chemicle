package com.chemcool.school.lesson.web.api.controllers;


import com.chemcool.school.lesson.tasks.chemequations.domain.ChemEquationsTask;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping({"/v1.0"})
@AllArgsConstructor
public class LessonRestController {

    private final TheoryRestController theoryRestController;
    private final ChemEquationsRestController chemEquationsRestController;
    private final ChemFixedAnswerRestController chemFixedAnswerRestController;
    private final ChemMatchesRestController matchesRestController;
    private final ChemSingleSelectRestController chemSingleSelectRestController;


    @ApiOperation("Find theory and all tasks by referenceId")
    @GetMapping("/getLessonByReferenceId")
    @ResponseStatus(HttpStatus.OK)
    public List[] findEquationsTaskByReferenceId(int referenceId) {
        return new List[]{
                theoryRestController.findTaskAndTheoryByReferences(referenceId),
                chemEquationsRestController.findEquationsTaskByReferenceId(referenceId),
                chemFixedAnswerRestController.findFixedAnswerTaskByReferences(referenceId),
                matchesRestController.findMatchesByReferences(referenceId),
                chemSingleSelectRestController.findTaskByReferences(referenceId)
        };
    }
}
