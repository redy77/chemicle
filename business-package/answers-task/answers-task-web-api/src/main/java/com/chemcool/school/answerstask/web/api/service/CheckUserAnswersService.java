package com.chemcool.school.answerstask.web.api.service;

import com.chemcool.school.answerstask.service.ChemEquationCorrectAnswersService;
import com.chemcool.school.answerstask.service.ChemFixedCorrectAnswersService;
import com.chemcool.school.answerstask.service.ChemSingleSelectCorrectAnswersService;
import com.chemcool.school.answerstask.service.ChemmathesCorrectAnswersService;
import com.chemcool.school.answerstask.tasks.chemmatches.domain.CoupleForMatching;
import com.chemcool.school.answerstask.web.api.domain.TaskType;
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

    public boolean checkUserAnswer(String taskId, TaskType taskType, String userAnswers) {
        boolean resultCheckUSerAnswer = false;//эта переменная на случай если будут добавляться типы задач...
        if (taskType.equals(TaskType.EQUATION)) {
            resultCheckUSerAnswer = userAnswers.equals(chemEquationCorrectAnswersService.getCorrectAnswerByIdTask(taskId));
        } else if (taskType.equals(TaskType.FIXED_ANSWER)) {
            resultCheckUSerAnswer = userAnswers.equals(chemFixedCorrectAnswersService.getCorrectAnswerByIdTask(taskId));
        } else if (taskType.equals(TaskType.SINGLE_SELECT)) {
            resultCheckUSerAnswer = userAnswers.equals(chemSingleSelectCorrectAnswersService.getCorrectAnswerByIdTask(taskId));
        }
        return resultCheckUSerAnswer;
    }

    public boolean checkUserAnswer(String taskId, List<CoupleForMatching> coupleForMatchingByUserList) {
        List<CoupleForMatching> coupleForMatchingByDataBase = chemmathesCorrectAnswersService.getCorrectCouplesByIdTask(taskId);
        Collections.sort(coupleForMatchingByUserList);
        Collections.sort(coupleForMatchingByDataBase);
        if (coupleForMatchingByUserList.equals(coupleForMatchingByDataBase)) {
            return true;
        }
        return false;
    }
}
