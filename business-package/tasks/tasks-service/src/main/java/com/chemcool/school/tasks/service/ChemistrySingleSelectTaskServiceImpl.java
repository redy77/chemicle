package com.chemcool.school.tasks.service;

import com.chemcool.school.tasks.domain.ChemistrySingleSelectTask;
import com.chemcool.school.tasks.storage.ChemistrySingleSelectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChemistrySingleSelectTaskServiceImpl implements ChemistryTaskService<ChemistrySingleSelectTask> {

    @Autowired
    ChemistrySingleSelectTaskRepository repository;

    @Override
    public String add(ChemistrySingleSelectTask chemistrySingleSelectTask) {
        chemistrySingleSelectTask.setId(UUID.randomUUID().toString());
        repository.save(chemistrySingleSelectTask);
        return chemistrySingleSelectTask.getId();
    }

    @Override
    public Optional<ChemistrySingleSelectTask> getById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<ChemistrySingleSelectTask> getAll() {
        return repository.findAll();
    }

    @Override
    public List<ChemistrySingleSelectTask> getAllByChapterId(String id) {
        return repository.getAllByChapterId(id);
    }

    @Override
    public void update(ChemistrySingleSelectTask chemistrySingleSelectTask) {
        repository.save(chemistrySingleSelectTask);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
