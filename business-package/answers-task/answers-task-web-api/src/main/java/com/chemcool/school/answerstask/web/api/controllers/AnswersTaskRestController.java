package com.chemcool.school.answerstask.web.api.controllers;

import com.chemcool.school.answerstask.domain.UserAnswersCorrect;
import com.chemcool.school.answerstask.service.UserAnswersCorrectService;
import com.chemcool.school.answerstask.tasks.chemmatches.domain.CoupleForMatching;
import com.chemcool.school.answerstask.web.api.domain.TaskType;
import com.chemcool.school.answerstask.web.api.service.CheckUserAnswersService;
import com.chemcool.school.answerstask.web.api.service.UserIdentJwtParser;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1.0")
@RequiredArgsConstructor
public class AnswersTaskRestController {

    private final CheckUserAnswersService checkUserAnswersService;
    private final UserIdentJwtParser jwtParser;
    private final UserAnswersCorrectService userAnswersCorrectService;

    @PostMapping
    @ApiOperation("Возвращает true или false ответ пользователю")
    public boolean checkAnswerUser(@RequestParam String taskId, @RequestParam TaskType taskType,
                                   @RequestParam(required = false) String userAnswers,
                                   @RequestBody(required = false) List<CoupleForMatching> coupleForMatchingList,
                                   @RequestHeader(value = "AuthorizationToken") String token) {

        if (userAnswers != null) {
            boolean checkUserAnswers = checkUserAnswersService.checkUserAnswer(taskId, taskType, userAnswers);
            UserAnswersCorrect userAnswersCorrect = new UserAnswersCorrect(jwtParser.getIdUserOfToken(token), jwtParser.getEmailUserOfToken(token), taskId);
            userAnswersCorrectService.saveUserCorrectAnswers(userAnswersCorrect);
            return checkUserAnswers;
            //сдулать обработки ошибок при сохранении одинаковых ответов и при ненахождении ответа в бд
        } else {
            return checkUserAnswersService.checkUserAnswer(taskId, coupleForMatchingList);
        }
    }
}
