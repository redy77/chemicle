package com.chemcool.school.tasks.service;

import com.chemcool.school.tasks.domain.FixedAnswer;
import com.chemcool.school.tasks.storage.FixedAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FixedAnswerService implements TaskService {

    @Autowired
    FixedAnswerRepository repository;

    @Override
    public String add(Object o) {
        FixedAnswer fixedAnswer = FixedAnswer.createFixedAnswer((FixedAnswer) o);
        repository.save(fixedAnswer);
        return fixedAnswer.getId();
    }

    @Override
    public Optional getById(String id) {
        Optional<FixedAnswer> fixedAnswer = repository.findById(id);
        return fixedAnswer;
    }

    @Override
    public List getAll() {
        return repository.findAll();
    }

    @Override
    public List getAllByChapterId(String id) { // ??????
        return null;
    }

    @Override
    public void update(Object o) {
        repository.save((FixedAnswer) o);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
