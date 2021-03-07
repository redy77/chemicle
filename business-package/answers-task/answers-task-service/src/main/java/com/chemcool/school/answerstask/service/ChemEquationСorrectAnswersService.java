package com.chemcool.school.answerstask.service;

import com.chemcool.school.answerstask.domain.ChemEquationСorrectAnswers;
import com.chemcool.school.answerstask.storage.ChemEquationСorrectAnswersRepository;
import com.chemcool.school.answerstask.tasks.chemequation.domain.ChemEquationsTask;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChemEquationСorrectAnswersService {
    private final ChemEquationСorrectAnswersRepository repository;

    public void saveCorrectAnswer(ChemEquationsTask task) {
        repository.save(ChemEquationСorrectAnswers.createChemequitationСorrectAnswers(task));
    }

    public String getCorrectAnswerByIdTask(String id) {
        ChemEquationСorrectAnswers сorrectAnswers = repository.findById(id).orElseThrow(()-> new IllegalArgumentException("Нет задачи с таким id"));
        return сorrectAnswers.getCorrectAnswer();
    }
}
