package com.chemcool.school.tasks.controllers.chemfixedanswer;

import com.chemcool.school.tasks.dto.chemfixedanswer.ChemFixedAnswerTaskCreateDto;
import com.chemcool.school.tasks.service.chemfixedanswer.ChemFixedAnswerTaskPresentation;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("chemFixedAnswer/v1.0")
@RequiredArgsConstructor
public class ChemFixedAnswerTaskRestController {

    private final ChemFixedAnswerTaskPresentation presentation;

    @PostMapping("/create")
    @ApiOperation("Создает новую сущность задания типа \"Фиксированный ответ\" по химии")
    public String saveNewFixedAnswerTask(@RequestBody ChemFixedAnswerTaskCreateDto taskDto){
        return presentation.createNewFixedAnswerTask(taskDto);
    }

    @PutMapping("/update")
    @ApiOperation("Сохраняет существующую сущность задания типа \"Фиксированный ответ\" по химии")
    public String saveFixedAnswerTask(@RequestBody ChemFixedAnswerTaskCreateDto taskDto){
        presentation.updateFixedAnswerTask(taskDto);
        return taskDto.getTaskId();
    }

    @DeleteMapping("/{id}")
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
