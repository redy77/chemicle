package com.chemcool.school.tasks.chemfixedanswer.service;

import com.chemcool.school.tasks.chemfixedanswer.domain.ChemistryFixedAnswerTask;
import com.chemcool.school.tasks.chemfixedanswer.domain.ChemistryFixedAnswerTaskExample;
import com.chemcool.school.tasks.chemfixedanswer.domain.ChemistryFixedAnswerTaskFactory;
import com.chemcool.school.tasks.chemfixedanswer.storage.ChemistryFixedAnswerTaskRepository;
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
    public void update(ChemistryFixedAnswerTask task) {
        repository.save(task);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
