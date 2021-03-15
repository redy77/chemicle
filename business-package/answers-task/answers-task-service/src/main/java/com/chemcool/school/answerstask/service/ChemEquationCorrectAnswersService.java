package com.chemcool.school.answerstask.service;

import com.chemcool.school.answerstask.domain.ChemEquationCorrectAswers;
import com.chemcool.school.answerstask.storage.ChemEquationCorrectAnswersRepository;
import com.chemcool.school.answerstask.tasks.chemequation.domain.ChemEquationsTask;
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
