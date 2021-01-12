package com.chemcool.school.domain.service;

import com.chemcool.school.domain.storage.SingleSelectQuestionRepository;
import com.chemcool.school.domain.tasks.domain.SingleSelectQuestion;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SingleSelectQuestionsServiceImpl implements SingleSelectQuestionsService{

    @Autowired
    SingleSelectQuestionRepository repository;

    @Override
    public List<SingleSelectQuestion> getAllTasks() {
        return repository.findAll();
    }

    @Override
    public SingleSelectQuestion getTaskById(String uuid) {
        return repository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Не найден элемент " + uuid));
    }

    @Override
    public void deleteTaskById(String uuid) {
        repository.deleteById(uuid);
    }

    @Override
    public void add(SingleSelectQuestion singleSelectQuestion) {
        repository.save(singleSelectQuestion);
    }
}
