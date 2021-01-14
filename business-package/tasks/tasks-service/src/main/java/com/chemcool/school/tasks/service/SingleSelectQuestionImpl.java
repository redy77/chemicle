package com.chemcool.school.tasks.service;

import com.chemcool.school.tasks.domain.SingleSelectQuestionTask;
import com.chemcool.school.tasks.storage.SingleSelectQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SingleSelectQuestionImpl implements TaskService<SingleSelectQuestionTask>{

    @Autowired
    SingleSelectQuestionRepository repository;

    @Override
    public String add(SingleSelectQuestionTask singleSelectQuestionTask) {
        singleSelectQuestionTask.setId(UUID.randomUUID().toString());
        repository.save(singleSelectQuestionTask);
        return singleSelectQuestionTask.getId();
    }

    @Override
    public Optional<SingleSelectQuestionTask> getById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<SingleSelectQuestionTask> getAll() {
        return repository.findAll();
    }

    @Override
    public List<SingleSelectQuestionTask> getAllByChapterId(String id) {
        return repository.getAllByChapterId(id);
    }

    @Override
    public void update(SingleSelectQuestionTask singleSelectQuestionTask) {
        repository.save(singleSelectQuestionTask);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
