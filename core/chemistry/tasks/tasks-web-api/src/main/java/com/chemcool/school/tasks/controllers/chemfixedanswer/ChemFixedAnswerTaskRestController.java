package com.chemcool.school.tasks.controllers.chemfixedanswer;

import com.chemcool.school.tasks.dto.chemfixedanswer.ChemFixedAnswerTaskCreateDto;
import com.chemcool.school.tasks.service.chemfixedanswer.ChemFixedAnswerTaskPresentation;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v.1.0/chemFixedAnswer")
@RequiredArgsConstructor
public class ChemFixedAnswerTaskRestController {

    private final ChemFixedAnswerTaskPresentation presentation;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Создает новую сущность задания типа \"Фиксированный ответ\" по химии")
    public String saveNewFixedAnswerTask(@RequestHeader(value = "Authorization") String token,
                                         @RequestBody ChemFixedAnswerTaskCreateDto taskDto) {
        return presentation.createNewFixedAnswerTask(taskDto, token);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Сохраняет существующую сущность задания типа \"Фиксированный ответ\" по химии")
    public String saveFixedAnswerTask(@RequestBody ChemFixedAnswerTaskCreateDto taskDto){
        presentation.updateFixedAnswerTask(taskDto);
        return taskDto.getTaskId();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Удалеят существующую сущность задания типа \"Фиксированный ответ\" по химии")
    public void deleteFixedAnswerTask(@PathVariable String id){
        presentation.deleteFixedAnswerTask(id);
    }

    @PostMapping("/checkAnswer")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Проверяет введенный ответ с ответом в базе данных \"Фиксированный ответ\"")
    public boolean checkAnswer(String taskId, String userAnswer) {
        return presentation.checkAnswer(taskId, userAnswer);
    }
}