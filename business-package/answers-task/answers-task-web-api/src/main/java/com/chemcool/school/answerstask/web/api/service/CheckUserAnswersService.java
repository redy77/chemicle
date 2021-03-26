package com.chemcool.school.answerstask.web.api.service;

import com.chemcool.school.answerstask.service.ChemEquationCorrectAnswersService;
import com.chemcool.school.answerstask.service.ChemFixedCorrectAnswersService;
import com.chemcool.school.answerstask.service.ChemSingleSelectCorrectAnswersService;
import com.chemcool.school.answerstask.service.ChemmathesCorrectAnswersService;
import com.chemcool.school.answerstask.tasks.chemmatches.domain.CoupleForMatching;
import com.chemcool.school.answerstask.web.api.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CheckUserAnswersService {
    private final ChemEquationCorrectAnswersService chemEquationCorrectAnswersService;
    private final ChemFixedCorrectAnswersService chemFixedCorrectAnswersService;
    private final ChemmathesCorrectAnswersService chemmathesCorrectAnswersService;
    private final ChemSingleSelectCorrectAnswersService chemSingleSelectCorrectAnswersService;

    public AnswerDto checkUserAnswer(String taskId, TaskType taskType, String userAnswers) {
        AnswerDto resultCheckUSerAnswer = null;//эта переменная на случай если будут добавляться типы задач...

        if (taskType.equals(TaskType.EQUATION)) {
            resultCheckUSerAnswer = new CheckEquationService().checkAnswer(
                            chemEquationCorrectAnswersService.getCorrectAnswerByIdTask(taskId),
                            userAnswers);

        } else if (taskType.equals(TaskType.FIXED_ANSWER)) {
            resultCheckUSerAnswer = new FixedAnswerDto();
            if(userAnswers.equals(chemFixedCorrectAnswersService.getCorrectAnswerByIdTask(taskId))){
                resultCheckUSerAnswer.setResult(true);
                resultCheckUSerAnswer.setScore(10);
            }
        } else if (taskType.equals(TaskType.SINGLE_SELECT)) {
            resultCheckUSerAnswer = new SingleSelectAnswerDto();
            if(userAnswers.equals(chemSingleSelectCorrectAnswersService.getCorrectAnswerByIdTask(taskId))){
                resultCheckUSerAnswer.setResult(true);
                resultCheckUSerAnswer.setScore(10);
            }
        }
        return resultCheckUSerAnswer;
    }

    public AnswerDto checkUserAnswer(String taskId, List<CoupleForMatching> coupleForMatchingByUserList) {
        MatchesAnswerDto resultCheckUserAnswer = new MatchesAnswerDto();
        List<CoupleForMatching> coupleForMatchingByDataBase = chemmathesCorrectAnswersService.getCorrectCouplesByIdTask(taskId);
        Collections.sort(coupleForMatchingByUserList);
        Collections.sort(coupleForMatchingByDataBase);
        if (coupleForMatchingByUserList.equals(coupleForMatchingByDataBase)) {
            resultCheckUserAnswer.setResult(true);
            resultCheckUserAnswer.setScore(10);
        }
        return resultCheckUserAnswer;
    }

}
