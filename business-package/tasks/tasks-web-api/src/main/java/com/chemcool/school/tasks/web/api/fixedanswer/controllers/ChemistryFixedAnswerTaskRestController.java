package com.chemcool.school.tasks.web.api.fixedanswer.controllers;


import com.chemcool.school.tasks.fixedanswer.domain.ChemistryFixedAnswerTask;
import com.chemcool.school.tasks.web.api.fixedanswer.dto.ChemistryFixedAnswerTaskDto;
import com.chemcool.school.tasks.web.api.fixedanswer.service.ChemistryFixedAnswerTaskPresentation;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks/fixed_answer")
@RequiredArgsConstructor
public class ChemistryFixedAnswerTaskRestController {

    @Autowired
    private final ChemistryFixedAnswerTaskPresentation presentation;

    @GetMapping("/")
    @ApiOperation("Возвращает все задания типа \"Фиксированный ответ\" по химии")
    public List<ChemistryFixedAnswerTaskDto> getAll(){
        return presentation.getAllChemistryFixedAnswerDto();
    }

    @PostMapping
    @ApiOperation("Добавляет новое задания типа \"Фиксированный ответ\" по химии")
    public String createNewFixedAnswerTask(@RequestBody ChemistryFixedAnswerTaskDto task){
        return presentation.createNewTask(task);
    }
}
