package com.chemcool.school.answers.service;

import com.chemcool.school.answers.storage.ChemSingleSelectCorrectAnswerRepository;
import com.chemcool.school.answers.tasks.chemsingleselect.domain.ChemSingleSelectTask;
import com.chemcool.school.answers.domain.ChemSingleSelectCorrectAnswers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChemSingleSelectCorrectAnswersService {
    private final ChemSingleSelectCorrectAnswerRepository repository;

    public void saveCorrectAnswers(ChemSingleSelectTask task) {
        repository.save(ChemSingleSelectCorrectAnswers.createChemSingleSelectCorrectAnswers(task));
    }

    public String getCorrectAnswerByIdTask(String taskId) {
        ChemSingleSelectCorrectAnswers сorrectAnswers = repository.findById(taskId).orElseThrow(()-> new IllegalArgumentException("Нет задачи с таким id"));
        return сorrectAnswers.getCorrectAnswer();
    }
}
