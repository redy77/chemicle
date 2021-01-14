package com.chemcool.school.tasks.service;

import com.chemcool.school.tasks.domain.SingleSelectQuestion;
import com.chemcool.school.tasks.domain.TypeOfTask;
import com.chemcool.school.tasks.storage.SingleSelectQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class SingleSelectQuestionImpl implements TaskService<SingleSelectQuestion>{

    @Autowired
    SingleSelectQuestionRepository repository;

    @Override
    public String add(SingleSelectQuestion singleSelectQuestion) {
        singleSelectQuestion.setId(UUID.randomUUID().toString());
        repository.save(singleSelectQuestion);
        return singleSelectQuestion.getId();
    }

    @Override
    public Optional<SingleSelectQuestion> getById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<SingleSelectQuestion> getAll() {
        return repository.findAll();
    }

    @Override
    public List<SingleSelectQuestion> getAllByChapterId(String id) {
        return repository.findAllByChapterId(id);
    }

    @Override
    public void update(SingleSelectQuestion singleSelectQuestion) {
        repository.save(singleSelectQuestion);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
