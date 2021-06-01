package com.chemcool.school.answers.web.api.controllers;

import com.chemcool.school.answers.domain.UserAnswersCorrect;
import com.chemcool.school.answers.domain.jwt.User;
import com.chemcool.school.answers.service.JwtAuthorizationService;
import com.chemcool.school.answers.service.UserAnswersCorrectService;
import com.chemcool.school.answers.domain.matches.CoupleForMatching;
import com.chemcool.school.answers.web.api.domain.AnswerDto;
import com.chemcool.school.answers.web.api.domain.TaskType;
import com.chemcool.school.answers.web.api.service.CheckResolverUserThisTask;
import com.chemcool.school.answers.web.api.service.CheckUserAnswersService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1.0")
@RequiredArgsConstructor
public class AnswersRestController {

    private final JwtAuthorizationService authorizationService;
    private final CheckUserAnswersService checkUserAnswersService;
    private final UserAnswersCorrectService userAnswersCorrectService;
    private final CheckResolverUserThisTask checkResolverUserThisTask;
    private final ObjectMapper objectMapper;
    private AnswerDto userAnswersDto;

    @PostMapping
    @ApiOperation("Возвращает AnswerDto в ответ пользователю")
    public ResponseEntity<String> checkAnswerUser(@RequestParam String taskId, @RequestParam TaskType taskType,
                                                  @RequestParam(required = false) String userAnswers,
                                                  @RequestBody(required = false) List<CoupleForMatching> coupleForMatchingList,
                                                  @RequestHeader(value = "AuthorizationToken") String token) throws JsonProcessingException {

        User user = authorizationService.getUser(token);
        System.out.println("user == "+user);


        if (checkResolverUserThisTask.checkScoreTasks(taskId, user.getUserId())) {
            return new ResponseEntity<>("Задача уже была решена пользователем", HttpStatus.OK);
        }

        if (userAnswers != null) {
            userAnswersDto = checkUserAnswersService.checkUserAnswer(taskId, taskType, userAnswers);
        } else {
            userAnswersDto = checkUserAnswersService.checkUserAnswer(taskId, coupleForMatchingList);
        }

        UserAnswersCorrect userAnswersCorrect = new UserAnswersCorrect(
                user.getUserId(),
                user.getEmail(),
                taskId,
                userAnswersDto.getScore());
        System.out.println("userAnswerCorrect == "+userAnswersCorrect );

        if (userAnswersDto.isResult()) {
            userAnswersCorrectService.delUserCorrectAnswers(taskId,user.getUserId());
            userAnswersCorrectService.saveUserCorrectAnswers(userAnswersCorrect);
        }
        return new ResponseEntity<>(objectMapper.writeValueAsString(userAnswersDto), HttpStatus.OK);
    }
}