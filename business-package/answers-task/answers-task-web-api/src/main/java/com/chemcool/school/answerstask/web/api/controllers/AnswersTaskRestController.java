package com.chemcool.school.answerstask.web.api.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v.1.0/answers-task")
public class AnswersTaskRestController {

    @GetMapping
    @ApiOperation("Возвращает true или false ответ пользователю")
    public boolean checkAnswerUser() {
        return true;
    }

}
