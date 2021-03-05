package com.chemcool.school.answerstask.service;

import com.chemcool.school.answerstask.storage.ChemSingleSelectCorrectAnswerRepository;
import com.chemcool.school.answerstask.tasks.chemsingleselect.domain.ChemSingleSelectTask;
import com.chemcool.school.answerstask.web.api.domain.ChemSingleSelectCorrectAnswers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChemSingleSelectCorrectAnswersService {
    private final ChemSingleSelectCorrectAnswerRepository repository;

    public void saveCorrectAnswers(ChemSingleSelectTask task) {
        repository.save(ChemSingleSelectCorrectAnswers.createChemSingleSelectCorrectAnswers(task));
    }
}
