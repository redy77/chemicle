package com.chemcool.school.tasks.chemequations.web.api.controllers;

import com.chemcool.school.tasks.chemequations.web.api.dto.ChemEquationsTaskDto;
import com.chemcool.school.tasks.chemequations.web.api.service.ChemEquationsTaskPresentation;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Контроллер взятый из модуля chemFixedAnswer(будет доработан)
 *
 * @version 1.0
 * @autor Иван Полещук
 */
@RestController
@RequestMapping("/v.1.0/tasks/equations")
@RequiredArgsConstructor
public class ChemEquationsRestController {

//    private final ChemEquationsTaskPresentation presentation;
//
//    @GetMapping
//    @ApiOperation("Возвращает сущности задания типа \"Фиксированный ответ\" по химии")
//    public List<ChemEquationsTaskDto> getAll() {
//        return presentation.getAllChemistryEquationsDto();
//    }
//
//    @GetMapping("/{id}")
//    @ApiOperation("Возвращает задание по ID типа \"Фиксированный ответ\" по химии")
//    public Optional<ChemEquationsTask> getEquationsTaskById(@PathVariable String id) {
//        return presentation.getEquationsTaskById(id);
//    }
//
//    @PostMapping
//    @ApiOperation("Создает новую сущность задания типа \"Фиксированный ответ\" по химии")
//    public String saveNewEquationsTask(@RequestBody ChemEquationsTaskDto taskDto) {
//        return presentation.createNewEquationsTask(taskDto);
//    }
//
//    @PutMapping
//    @ApiOperation("Сохраняет существующую сущность задания типа \"Фиксированный ответ\" по химии")
//    public String saveEquationsTask(@RequestBody ChemEquationsTaskDto taskDto) {
//        presentation.updateEquationsTask(taskDto);
//        return taskDto.getTaskId();
//    }
//
//    @DeleteMapping("/{id}")
//    @ApiOperation("Удаляет существующую сущность задания типа \"Фиксированный ответ\" по химии")
//    public void deleteEquationsTask(@PathVariable String id) {
//        presentation.deleteEquationsTask(id);
//    }
}