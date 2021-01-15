package com.chemcool.school.tasks.service;

import com.chemcool.school.tasks.domain.ChemistryFixedAnswerTask;
import com.chemcool.school.tasks.storage.ChemistryFixedAnswerTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChemistryFixedAnswerTaskServiceImpl implements ChemistryTaskService<ChemistryFixedAnswerTask> {

    @Autowired
    ChemistryFixedAnswerTaskRepository repository;

    @Override
    public String add(ChemistryFixedAnswerTask chemistryFixedAnswerTask) {
        chemistryFixedAnswerTask.setChemistryFixedAnswerTaskUuid(UUID.randomUUID().toString());
        repository.save(chemistryFixedAnswerTask);
        return chemistryFixedAnswerTask.getChemistryFixedAnswerTaskUuid();
    }

    @Override
    public Optional<ChemistryFixedAnswerTask> getById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<ChemistryFixedAnswerTask> getAll() {
        return repository.findAll();
    }

    @Override
    public List<ChemistryFixedAnswerTask> getAllByChapterId(String chapterId) { // ??????
        return repository.findAllByChapterId(chapterId);
    }

    @Override
    public void update(ChemistryFixedAnswerTask chemistryFixedAnswerTask) {
        repository.save(chemistryFixedAnswerTask);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
