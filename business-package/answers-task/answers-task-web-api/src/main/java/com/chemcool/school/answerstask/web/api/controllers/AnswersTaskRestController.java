package com.chemcool.school.answerstask.web.api.controllers;

import com.chemcool.school.answerstask.tasks.chemmatches.domain.CoupleForMatching;
import com.chemcool.school.answerstask.web.api.domain.TaskType;
import com.chemcool.school.answerstask.web.api.service.CheckUserAnswersService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v.1.0/answers-task")
@RequiredArgsConstructor
public class AnswersTaskRestController {

    private final CheckUserAnswersService checkUserAnswersService;

    @PostMapping("/{taskId}")
    @ApiOperation("Возвращает true или false ответ пользователю")
    public boolean checkAnswerUser(@PathVariable String taskId, @RequestParam TaskType taskType,
                                   @RequestParam(required = false) String userAnswers,
                                   @RequestBody(required = false) CoupleForMatching coupleForMatching) {

        boolean resultOfChecking = true;

        if (userAnswers != null) {
            resultOfChecking = checkUserAnswersService.checkUserAnswer(taskId, taskType, userAnswers);
        } else {
            resultOfChecking = checkUserAnswersService.checkUserAnswer(taskId, taskType, coupleForMatching);
        }
        return resultOfChecking;
    }
}
