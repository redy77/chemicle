package com.chemcool.school.tasks.fixedanswer.service;

import com.chemcool.school.tasks.fixedanswer.domain.ChemistryFixedAnswerTask;
import com.chemcool.school.tasks.fixedanswer.domain.ChemistryFixedAnswerTaskExample;
import com.chemcool.school.tasks.fixedanswer.domain.ChemistryFixedAnswerTaskFactory;
import com.chemcool.school.tasks.fixedanswer.storage.ChemistryFixedAnswerTaskRepository;
import com.chemcool.school.tasks.service.ChemistryTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChemistryFixedAnswerTaskService implements ChemistryTaskService<ChemistryFixedAnswerTask, ChemistryFixedAnswerTaskExample> {

    @Autowired
    ChemistryFixedAnswerTaskRepository repository;

    @Override
    public String add(ChemistryFixedAnswerTaskExample example) {
        ChemistryFixedAnswerTask fixedAnswerTask = ChemistryFixedAnswerTaskFactory.createChemistryFixedAnswerTask(example);
        repository.save(fixedAnswerTask);
        return fixedAnswerTask.getChemistryFixedAnswerTaskUuid();
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
    public List<ChemistryFixedAnswerTask> getAllByChapterId(String chapterId) {
        return repository.findAllByChapterId(chapterId);
    }

    @Override
    public void update(ChemistryFixedAnswerTaskExample example) {
        ChemistryFixedAnswerTask fixedAnswerTask = ChemistryFixedAnswerTask.createChemistryFixedAnswerTask(example);
        repository.save(fixedAnswerTask);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
