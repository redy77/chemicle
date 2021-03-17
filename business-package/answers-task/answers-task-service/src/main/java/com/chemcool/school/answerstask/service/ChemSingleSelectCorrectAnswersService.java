package com.chemcool.school.answerstask.service;

import com.chemcool.school.answerstask.domain.ChemFixedCorrectAnswers;
import com.chemcool.school.answerstask.storage.ChemSingleSelectCorrectAnswerRepository;
import com.chemcool.school.answerstask.tasks.chemsingleselect.domain.ChemSingleSelectTask;
import com.chemcool.school.answerstask.domain.ChemSingleSelectCorrectAnswers;
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
