package com.chemcool.school.tasks.chemfixedanswer.web.api.controllers;


import com.chemcool.school.tasks.chemfixedanswer.domain.ChemistryFixedAnswerTask;
import com.chemcool.school.tasks.chemfixedanswer.web.api.dto.ChemistryFixedAnswerTaskDto;
import com.chemcool.school.tasks.chemfixedanswer.web.api.service.ChemistryFixedAnswerTaskPresentation;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v.1.0/tasks/fixed-answer")
@RequiredArgsConstructor
public class ChemistryFixedAnswerTaskRestController {

    @Autowired
    private final ChemistryFixedAnswerTaskPresentation presentation;

    @GetMapping
    @ApiOperation("Возвращает сущности задания типа \"Фиксированный ответ\" по химии")
    public List<ChemistryFixedAnswerTaskDto> getAll(){
        return presentation.getAllChemistryFixedAnswerDto();
    }

    @GetMapping("/{id}")
    @ApiOperation("Возвращает задани по ID типа \"Фиксированный ответ\" по химии")
    public Optional<ChemistryFixedAnswerTask> getFixedAnswerTaskById (@PathVariable String id){
        return presentation.getFixedAnswerTaskById(id);
    }

    @PostMapping
    @ApiOperation("Создает новую сущность задания типа \"Фиксированный ответ\" по химии")
    public String createNewFixedAnswerTask(@RequestBody ChemistryFixedAnswerTaskDto taskDto){
        return presentation.createNewFixedAnswerTask(taskDto);
    }

    @PutMapping
    @ApiOperation("Сохраняет существующую сущность задания типа \"Фиксированный ответ\" по химии")
    public String update(@RequestBody ChemistryFixedAnswerTaskDto taskDto){
        presentation.updateFixedAnswerTask(taskDto);
        return taskDto.getTaskId();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Удалеят существующую сущность задания типа \"Фиксированный ответ\" по химии")
    public void deleteFixedAnswerTask(@PathVariable String id){
        presentation.deleteFixedAnswerTask(id);
    }
}
