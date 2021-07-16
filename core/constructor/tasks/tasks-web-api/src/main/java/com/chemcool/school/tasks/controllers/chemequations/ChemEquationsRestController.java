package com.chemcool.school.tasks.controllers.chemequations;

import com.chemcool.school.tasks.dto.chemequations.ChemAnswerDto;
import com.chemcool.school.tasks.dto.chemequations.ChemEquationsTaskCreateDto;
import com.chemcool.school.tasks.dto.chemequations.ChemEquationsTaskDto;
import com.chemcool.school.tasks.service.chemequations.ChemEquationsTaskPresentation;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v.1.0/chemEquations/")
@RequiredArgsConstructor
public class ChemEquationsRestController {

    @Autowired
    private final ChemEquationsTaskPresentation presentation;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Создает новую сущность задания типа \"Уравнения\"")
    public String saveNewEquationsTask(@RequestHeader(value = "Authorization") String token,
                                       ChemEquationsTaskCreateDto taskDto, String rightAnswer) {
        return presentation.createNewEquationsTask(taskDto, rightAnswer, token);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Обновляет существующую сущность задания типа \"Уравнения\"")
    public void saveEquationsTask(@RequestBody ChemEquationsTaskCreateDto taskDto) {
        presentation.updateEquationsTask(taskDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Удаляет существующую сущность задания типа \"Уравнения\"")
    public void deleteEquationsTask(@PathVariable String id) {
        presentation.deleteEquationsTask(id);
    }

    @PostMapping("/checkAnswer")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Проверяет введенный ответ с ответом в базе данных \"Уравнения\"")
    public ChemAnswerDto checkAnswer(String taskId, String userAnswer) {
        return presentation.checkAnswer(taskId, userAnswer);
    }

}