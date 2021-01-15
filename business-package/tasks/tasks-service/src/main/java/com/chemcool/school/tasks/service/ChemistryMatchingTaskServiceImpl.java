package com.chemcool.school.tasks.service;

import com.chemcool.school.tasks.domain.ChemistryMatchingTask;
import com.chemcool.school.tasks.storage.ChemistryMatchingTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChemistryMatchingTaskServiceImpl implements ChemistryTaskService<ChemistryMatchingTask> {

    private final ChemistryMatchingTaskRepository chemistryMatchingTaskRepository;

    @Autowired
    public ChemistryMatchingTaskServiceImpl(ChemistryMatchingTaskRepository chemistryMatchingTaskRepository) {
        this.chemistryMatchingTaskRepository = chemistryMatchingTaskRepository;
    }

    @Override
    public String add(ChemistryMatchingTask chemistryMatchingTask) {
        chemistryMatchingTask.setId(UUID.randomUUID().toString());
        chemistryMatchingTaskRepository.save(chemistryMatchingTask);
        return chemistryMatchingTask.getId();
    }

    @Override
    public Optional<ChemistryMatchingTask> getById(String id) {
        return chemistryMatchingTaskRepository.findById(id);
    }

    @Override
    public List<ChemistryMatchingTask> getAll() {
        return chemistryMatchingTaskRepository.findAll();
    }

    @Override
    public List<ChemistryMatchingTask> getAllByChapterId(String id) {
        return chemistryMatchingTaskRepository.findByChapterId(id);
    }

    @Override
    public void update(ChemistryMatchingTask chemistryMatchingTask) {
        chemistryMatchingTaskRepository.save(chemistryMatchingTask);
    }

    @Override
    public void deleteById(String id) {
        chemistryMatchingTaskRepository.deleteById(id);
    }
}
