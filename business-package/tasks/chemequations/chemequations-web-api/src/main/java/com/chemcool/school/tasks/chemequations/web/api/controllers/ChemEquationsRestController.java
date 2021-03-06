package com.chemcool.school.tasks.chemequations.web.api.controllers;

import com.chemcool.school.tasks.chemequations.domain.ChemEquationsTask;
import com.chemcool.school.tasks.chemequations.web.api.dto.ChemAnswerDto;
import com.chemcool.school.tasks.chemequations.web.api.dto.ChemEquationsTaskDto;
import com.chemcool.school.tasks.chemequations.web.api.service.ChemEquationsTaskPresentation;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/equations/v.1.0")
@RequiredArgsConstructor
public class ChemEquationsRestController {

    private final ChemEquationsTaskPresentation presentation;

    @GetMapping
    @ApiOperation("Возвращает сущности задания типа \"Уравнения\" по химии")
    public List<ChemEquationsTaskDto> getAll() {
        return presentation.getAllChemistryEquationsDto();
    }

    @GetMapping("/{id}")
    @ApiOperation("Возвращает задание по ID типа \"Уравнения\" по химии")
    public Optional<ChemEquationsTask> getEquationsTaskById(@PathVariable String id) {
        return presentation.getEquationsTaskById(id);
    }

    @PostMapping
    @ApiOperation("Создает новую сущность задания типа \"Уравнения\" по химии")
    public String saveNewEquationsTask(ChemEquationsTaskDto taskDto) {
        return presentation.createNewEquationsTask(taskDto);
    }

    @PutMapping
    @ApiOperation("Сохраняет существующую сущность задания типа \"Уравнения\" по химии")
    public String saveEquationsTask(@RequestBody ChemEquationsTaskDto taskDto) {
        presentation.updateEquationsTask(taskDto);
        return taskDto.getTaskId();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Удаляет существующую сущность задания типа \"Уравнения\" по химии")
    public void deleteEquationsTask(@PathVariable String id) {
        presentation.deleteEquationsTask(id);
    }

    @PostMapping("/checkAnswer")
    public ChemAnswerDto checkAnswer(String taskId, String userAnswer) {
        return presentation.checkAnswer(taskId, userAnswer);
    }
}