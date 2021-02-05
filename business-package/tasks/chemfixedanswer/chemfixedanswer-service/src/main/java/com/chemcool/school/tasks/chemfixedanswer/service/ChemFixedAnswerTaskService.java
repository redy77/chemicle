package com.chemcool.school.tasks.chemfixedanswer.service;

import com.chemcool.school.tasks.chemfixedanswer.domain.ChemFixedAnswerTask;
import com.chemcool.school.tasks.chemfixedanswer.domain.ChemFixedAnswerTaskEvent;
import com.chemcool.school.tasks.chemfixedanswer.domain.ChemFixedAnswerTaskExample;
import com.chemcool.school.tasks.chemfixedanswer.domain.ChemFixedAnswerTaskFactory;
import com.chemcool.school.tasks.chemfixedanswer.storage.ChemFixedAnswerTaskEventJournal;
import com.chemcool.school.tasks.chemfixedanswer.storage.ChemFixedAnswerTaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChemFixedAnswerTaskService {

    private final ChemFixedAnswerTaskRepository repository;
    private final ChemFixedAnswerTaskEventService event;
    private final ChemFixedAnswerTaskEventJournal journal;

    public String add(ChemFixedAnswerTaskExample example) {
        ChemFixedAnswerTask task = ChemFixedAnswerTaskFactory.createChemistryFixedAnswerTask(example);
        event.handleEvent(task);
        repository.save(task);
        log.info("Добавлена задача с ID: " + task.getTaskId());
        return task.getTaskId();
    }

    public Optional<ChemFixedAnswerTask> getById(String id) {
        return repository.findById(id);
    }

    public List<ChemFixedAnswerTask> getAll() {
        return repository.findAll();
    }

    public List<ChemFixedAnswerTask> getAllByChapterId(int chapterId) {
        return repository.findAllByChapterId(chapterId);
    }

//    public void update(ChemFixedAnswerTask task) {
//        event.update(task);
//        repository.save(task);
//        log.info("Обновлена задача с ID: " + task.getTaskId());
//    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public void handleEvent(ChemFixedAnswerTaskEvent event) {
        journal.save(event);
    }
}
