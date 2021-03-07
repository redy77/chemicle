package com.chemcool.school.answerstask.web.api.controllers;

import com.chemcool.school.answerstask.tasks.chemmatches.domain.CoupleForMatching;
import com.chemcool.school.answerstask.web.api.domain.TaskType;
import com.chemcool.school.answerstask.web.api.service.CheckUserAnswersService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1.0")
@RequiredArgsConstructor
public class AnswersTaskRestController {

    private final CheckUserAnswersService checkUserAnswersService;

    @PostMapping
    @ApiOperation("Возвращает true или false ответ пользователю")
    public boolean checkAnswerUser(@RequestParam String taskId, @RequestParam TaskType taskType,
                                   @RequestParam(required = false) String userAnswers,
                                   @RequestBody(required = false) List<CoupleForMatching> coupleForMatchingList) {

        if (userAnswers != null) {
            return checkUserAnswersService.checkUserAnswer(taskId, taskType, userAnswers);
        } else {
            return checkUserAnswersService.checkUserAnswer(taskId, coupleForMatchingList);
        }

        //можно попробовать в параметрах контролера вместо requestParam requestBody с Map<String, String> payload.
    }
}
