package com.chemcool.school.answerstask.web.api.controllers;

import com.chemcool.school.answerstask.domain.UserAnswersCorrect;
import com.chemcool.school.answerstask.service.UserAnswersCorrectService;
import com.chemcool.school.answerstask.tasks.chemmatches.domain.CoupleForMatching;
import com.chemcool.school.answerstask.web.api.domain.TaskType;
import com.chemcool.school.answerstask.web.api.service.CheckResolverUserThisTask;
import com.chemcool.school.answerstask.web.api.service.CheckUserAnswersService;
import com.chemcool.school.answerstask.web.api.service.UserIdentJwtParser;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1.0")
@RequiredArgsConstructor
public class AnswersTaskRestController {

    private final CheckUserAnswersService checkUserAnswersService;
    private final UserIdentJwtParser jwtParser;
    private final UserAnswersCorrectService userAnswersCorrectService;
    private final CheckResolverUserThisTask checkResolverUserThisTask;

    @PostMapping
    @ApiOperation("Возвращает true или false ответ пользователю")
    public ResponseEntity<String> checkAnswerUser(@RequestParam String taskId, @RequestParam TaskType taskType,
                                                  @RequestParam(required = false) String userAnswers,
                                                  @RequestBody(required = false) List<CoupleForMatching> coupleForMatchingList,
                                                  @RequestHeader(value = "AuthorizationToken") String token) {

        String userId = jwtParser.getIdUserOfToken(token);
        boolean checkUserAnswers;
        if (checkResolverUserThisTask.checkResolverUserThisTask(taskId, userId)) {
            return new ResponseEntity<>("Задача уже была решена пользователем", HttpStatus.OK);
        }

        UserAnswersCorrect userAnswersCorrect = new UserAnswersCorrect(userId, jwtParser.getEmailUserOfToken(token), taskId);

        if (userAnswers != null) {
            if (checkUserAnswers = checkUserAnswersService.checkUserAnswer(taskId, taskType, userAnswers)) {
                userAnswersCorrectService.saveUserCorrectAnswers(userAnswersCorrect);
            }
        } else {
            checkUserAnswers = checkUserAnswersService.checkUserAnswer(taskId, coupleForMatchingList);
            userAnswersCorrectService.saveUserCorrectAnswers(userAnswersCorrect);
        }
        return new ResponseEntity<>(Boolean.toString(checkUserAnswers), HttpStatus.OK);
    }
}
