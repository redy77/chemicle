package com.chemcool.school.answers.service;

import com.chemcool.school.answers.domain.ChemEquationCorrectAswers;
import com.chemcool.school.answers.storage.ChemEquationCorrectAnswersRepository;
import com.chemcool.school.answers.tasks.chemequation.domain.ChemEquationsTask;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChemEquationCorrectAnswersService {
    private final ChemEquationCorrectAnswersRepository repository;

    public void saveCorrectAnswer(ChemEquationsTask task) {
        repository.save(ChemEquationCorrectAswers.createChemequitationСorrectAnswers(task));
    }

    public String getCorrectAnswerByIdTask(String id) {
        ChemEquationCorrectAswers сorrectAnswers = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Нет задачи с таким id"));
        return сorrectAnswers.getCorrectAnswer();
    }
}
