package com.chemcool.school.tasks.service;

import com.chemcool.school.tasks.domain.FixedAnswer;
import com.chemcool.school.tasks.storage.FixedAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FixedAnswerServiceImpl implements TaskService<FixedAnswer> {

    @Autowired
    FixedAnswerRepository repository;

    @Override
    public String add(FixedAnswer fixedAnswer) {
        fixedAnswer.setId(UUID.randomUUID().toString());
        repository.save(fixedAnswer);
        return fixedAnswer.getId();
    }

    @Override
    public Optional<FixedAnswer> getById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<FixedAnswer> getAll() {
        return repository.findAll();
    }

    @Override
    public List<FixedAnswer> getAllByChapterId(String id) { // ??????
        return repository.findAllByChapterId(id);
    }

    @Override
    public void update(FixedAnswer fixedAnswer) {
        repository.save(fixedAnswer);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
