package com.chemcool.school.tasks.service;

import com.chemcool.school.tasks.domain.FixedAnswerTask;
import com.chemcool.school.tasks.storage.FixedAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FixedAnswerServiceImpl implements TaskService<FixedAnswerTask> {

    @Autowired
    FixedAnswerRepository repository;

    @Override
    public String add(FixedAnswerTask fixedAnswerTask) {
        fixedAnswerTask.setId(UUID.randomUUID().toString());
        repository.save(fixedAnswerTask);
        return fixedAnswerTask.getId();
    }

    @Override
    public Optional<FixedAnswerTask> getById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<FixedAnswerTask> getAll() {
        return repository.findAll();
    }

    @Override
    public List<FixedAnswerTask> getAllByChapterId(String id) { // ??????
        return repository.findAllByChapterId(id);
    }

    @Override
    public void update(FixedAnswerTask fixedAnswerTask) {
        repository.save(fixedAnswerTask);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
