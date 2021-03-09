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
    @ApiOperation("Возвращает все сущности задания типа \"Уравнения\"")
    public List<ChemEquationsTaskDto> getAll() {
        return presentation.getAllChemistryEquationsDto();
    }

    @GetMapping("/chapter/{chapterId}")
    @ApiOperation("Возвращает все сущности задания типа \"Уравнения\" по главе")
    public List<ChemEquationsTaskDto> getAllByChapterId(@PathVariable int chapterId) {
        return presentation.getAllChemistryEquationsByChapterIdDto(chapterId);
    }

    @GetMapping("/reference/{chapterId}/{referenceId}")
    @ApiOperation("Возвращает все сущности задания типа \"Уравнения\" по разделу и главе")
    public List<ChemEquationsTaskDto> getAllByReferenceId(@PathVariable int chapterId,@PathVariable int referenceId) {
        return presentation.getAllChemistryEquationsByChapterIdAndReferenceIdDto(chapterId,referenceId);
    }

    @GetMapping("/{id}")
    @ApiOperation("Возвращает задание по ID типа \"Уравнения\"")
    public ChemEquationsTaskDto getEquationsTaskById(@PathVariable String id) {
        return presentation.getEquationsTaskById(id);
    }

    @GetMapping("/randomTask")
    @ApiOperation("Возвращает все сущности задания типа \"Уравнения\"")
    public ChemEquationsTaskDto getRandomTask() {
        return presentation.getRandomChemistryEquationsDto();
    }

    @PostMapping
    @ApiOperation("Создает новую сущность задания типа \"Уравнения\"")
    public String saveNewEquationsTask(ChemEquationsTaskDto taskDto, String rightAnswer) {
        return presentation.createNewEquationsTask(taskDto,rightAnswer);
    }

    @PutMapping
    @ApiOperation("Обновляет существующую сущность задания типа \"Уравнения\"")
    public void saveEquationsTask(ChemEquationsTaskDto taskDto,String rightAnswer) {
        presentation.updateEquationsTask(taskDto,rightAnswer);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Удаляет существующую сущность задания типа \"Уравнения\"")
    public void deleteEquationsTask(@PathVariable String id) {
        presentation.deleteEquationsTask(id);
    }

    @PostMapping("/checkAnswer")
    @ApiOperation("Проверяет введенный ответ с ответом в базе данных \"Уравнения\"")
    public ChemAnswerDto checkAnswer(String taskId, String userAnswer) {
        return presentation.checkAnswer(taskId, userAnswer);
    }
}