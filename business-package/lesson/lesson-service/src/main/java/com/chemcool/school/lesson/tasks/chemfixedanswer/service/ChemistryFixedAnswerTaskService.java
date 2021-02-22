package com.chemcool.school.lesson.tasks.chemfixedanswer.service;

import com.chemcool.school.lesson.tasks.chemfixedanswer.domain.ChemistryFixedAnswerTask;
import com.chemcool.school.lesson.tasks.chemfixedanswer.domain.ChemistryFixedAnswerTaskExample;
import com.chemcool.school.lesson.tasks.chemfixedanswer.domain.ChemistryFixedAnswerTaskFactory;
import com.chemcool.school.lesson.tasks.chemfixedanswer.storage.ChemistryFixedAnswerTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChemistryFixedAnswerTaskService {

    @Autowired
    ChemistryFixedAnswerTaskRepository repository;

    public String add(ChemistryFixedAnswerTaskExample example) {
        ChemistryFixedAnswerTask fixedAnswerTask = ChemistryFixedAnswerTaskFactory.createChemistryFixedAnswerTask(example);
        repository.save(fixedAnswerTask);
        return fixedAnswerTask.getTaskId();
    }

    public Optional<ChemistryFixedAnswerTask> getById(String id) {
        return repository.findById(id);
    }

    public List<ChemistryFixedAnswerTask> getAll() {
        return repository.findAll();
    }

    public List<ChemistryFixedAnswerTask> getAllByChapterId(String chapterId) {
        return repository.findAllByChapterId(chapterId);
    }

    public void update(ChemistryFixedAnswerTask task) {
        repository.save(task);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
