package com.chemcool.school.answerstask.service;

import com.chemcool.school.answerstask.domain.CmemequitationСorrectAnswers;
import com.chemcool.school.answerstask.storage.CmemequitationСorrectAnswersServiceRepository;
import com.chemcool.school.answerstask.tasks.chemequitation.domain.ChemEquationsTask;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CmemequitationСorrectAnswersService {
    private final CmemequitationСorrectAnswersServiceRepository repository;

    public void saveCorrectAnswer(ChemEquationsTask task) {
        CmemequitationСorrectAnswers cmemequitationСorrectAnswers = new CmemequitationСorrectAnswers();
        cmemequitationСorrectAnswers.setId(task.getTaskId());
        cmemequitationСorrectAnswers.setCorrectAnswer(task.getRightAnswer());
        repository.save(cmemequitationСorrectAnswers);
    }
}
