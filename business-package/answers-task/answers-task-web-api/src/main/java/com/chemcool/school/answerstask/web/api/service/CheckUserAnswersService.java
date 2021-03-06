package com.chemcool.school.answerstask.web.api.service;

import com.chemcool.school.answerstask.service.ChemEquationСorrectAnswersService;
import com.chemcool.school.answerstask.service.ChemFixedCorrectAnswersService;
import com.chemcool.school.answerstask.service.ChemSingleSelectCorrectAnswersService;
import com.chemcool.school.answerstask.service.ChemmathesCorrectAnswersService;
import com.chemcool.school.answerstask.tasks.chemmatches.domain.CoupleForMatching;
import com.chemcool.school.answerstask.web.api.domain.TaskType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckUserAnswersService {
    private final ChemEquationСorrectAnswersService chemEquationСorrectAnswersService;
    private final ChemFixedCorrectAnswersService chemFixedCorrectAnswersService;
    private final ChemmathesCorrectAnswersService chemmathesCorrectAnswersService;
    private final ChemSingleSelectCorrectAnswersService chemSingleSelectCorrectAnswersService;

    public boolean checkUserAnswer(String taskId, TaskType taskType, String userAnswers) {
        return true;
    }

    public boolean checkUserAnswer(String taskId, TaskType taskType, CoupleForMatching coupleForMatching) {
        return false;
    }

}
