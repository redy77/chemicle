package com.chemcool.school.answerstask.service;

import com.chemcool.school.answerstask.web.api.domain.ChemFixedCorrectAnswers;
import com.chemcool.school.answerstask.storage.ChemFixedCorrectAnswersRepository;
import com.chemcool.school.answerstask.tasks.chemfixedanswer.domain.ChemFixedAnswerTask;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChemFixedCorrectAnswersService {
    private final ChemFixedCorrectAnswersRepository repository;

    public void saveCorrectAnswers(ChemFixedAnswerTask task) {
        repository.save(ChemFixedCorrectAnswers.createChemFixedCorrectAnswers(task));
    }
}
