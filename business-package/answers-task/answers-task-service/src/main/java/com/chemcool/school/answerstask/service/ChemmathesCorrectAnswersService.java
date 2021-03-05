package com.chemcool.school.answerstask.service;

import com.chemcool.school.answerstask.web.api.domain.ChemmathesCorrectAnswers;
import com.chemcool.school.answerstask.storage.ChemmathesCorrectAnswersRepository;
import com.chemcool.school.answerstask.tasks.chemmatches.domain.ChemistryMatchingTask;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChemmathesCorrectAnswersService {
    private final ChemmathesCorrectAnswersRepository repository;

    public void saveCorrectAnswers(ChemistryMatchingTask task) {
        repository.save(ChemmathesCorrectAnswers.createChemmathesCorrectAnswers(task));
    }
}
