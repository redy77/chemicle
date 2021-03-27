package com.chemcool.school.tasks.chemfixedanswer.web.api.controllers;


import com.chemcool.school.tasks.chemfixedanswer.domain.ChemFixedAnswerTask;
import com.chemcool.school.tasks.chemfixedanswer.web.api.dto.ChemFixedAnswerTaskDto;
import com.chemcool.school.tasks.chemfixedanswer.web.api.service.ChemFixedAnswerTaskPresentation;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v.1.0/tasks/fixed-answer")
@RequiredArgsConstructor
public class ChemFixedAnswerTaskRestController {

    private final ChemFixedAnswerTaskPresentation presentation;

    @GetMapping
    @ApiOperation("Возвращает сущности задания типа \"Фиксированный ответ\" по химии")
    public List<ChemFixedAnswerTaskDto> getAll(){
        return presentation.getAllChemistryFixedAnswerDto();
    }

    @GetMapping("/{id}")
    @ApiOperation("Возвращает задани по ID типа \"Фиксированный ответ\" по химии")
    public Optional<ChemFixedAnswerTask> getFixedAnswerTaskById (@PathVariable String id){
        return presentation.getFixedAnswerTaskById(id);
    }

    @PostMapping
    @ApiOperation("Создает новую сущность задания типа \"Фиксированный ответ\" по химии")
    public String saveNewFixedAnswerTask(@RequestBody ChemFixedAnswerTaskDto taskDto){
        return presentation.createNewFixedAnswerTask(taskDto);
    }

    @PutMapping
    @ApiOperation("Сохраняет существующую сущность задания типа \"Фиксированный ответ\" по химии")
    public String saveFixedAnswerTask(@RequestBody ChemFixedAnswerTaskDto taskDto){
        presentation.updateFixedAnswerTask(taskDto);
        return taskDto.getTaskId();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Удалеят существующую сущность задания типа \"Фиксированный ответ\" по химии")
    public void deleteFixedAnswerTask(@PathVariable String id){
        presentation.deleteFixedAnswerTask(id);
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }
}
