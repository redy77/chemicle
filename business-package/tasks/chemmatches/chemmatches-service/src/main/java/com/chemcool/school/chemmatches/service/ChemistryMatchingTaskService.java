package com.chemcool.school.chemmatches.service;

import com.chemcool.school.chemmatches.domain.ChemistryMatchingTask;
import com.chemcool.school.chemmatches.domain.ChemistryMatchingTaskExample;
import com.chemcool.school.chemmatches.domain.ChemistryMatchingTaskFactory;
import com.chemcool.school.chemmatches.storage.ChemistryMatchingTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChemistryMatchingTaskService implements ChemistryTaskService<ChemistryMatchingTask, ChemistryMatchingTaskExample> {

    private final ChemistryMatchingTaskRepository chemistryMatchingTaskRepository;

    @Autowired
    public ChemistryMatchingTaskService(ChemistryMatchingTaskRepository chemistryMatchingTaskRepository) {
        this.chemistryMatchingTaskRepository = chemistryMatchingTaskRepository;
    }

    @Override
    public String add(ChemistryMatchingTaskExample chemistryMatchingTaskExample) {
        ChemistryMatchingTask newChemistryMatchingTask = ChemistryMatchingTaskFactory.createChemistryMatchingTask(chemistryMatchingTaskExample);
        chemistryMatchingTaskRepository.save(newChemistryMatchingTask);
        return newChemistryMatchingTask.getChemistryMatchingTaskUuid();
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
    public List<ChemistryMatchingTask> getAllByChapterId(String chapterId) {
        return chemistryMatchingTaskRepository.findByChapterId(chapterId);
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