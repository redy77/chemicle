package com.chemcool.school.answerstask.service;

import com.chemcool.school.answerstask.web.api.domain.ChemEquationСorrectAnswers;
import com.chemcool.school.answerstask.storage.ChemEquationСorrectAnswersServiceRepository;
import com.chemcool.school.answerstask.tasks.chemequation.domain.ChemEquationsTask;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChemEquationСorrectAnswersService {
    private final ChemEquationСorrectAnswersServiceRepository repository;

    public void saveCorrectAnswer(ChemEquationsTask task) {
        repository.save(ChemEquationСorrectAnswers.createChemequitationСorrectAnswers(task));
    }
}
