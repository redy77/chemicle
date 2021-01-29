package com.chemcool.school.tasks.chemsingleselect.service;


import com.chemcool.school.tasks.chemsingleselect.domain.ChemSingleSelectTask;
import com.chemcool.school.tasks.chemsingleselect.domain.ChemSingleSelectTaskExample;
import com.chemcool.school.tasks.chemsingleselect.domain.ChemSingleSelectTaskFactory;
import com.chemcool.school.tasks.chemsingleselect.storage.ChemSingleSelectTaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChemSingleSelectTaskService {

    private final ChemSingleSelectTaskRepository repository;

    public String add(ChemSingleSelectTaskExample exampleTask) {
        ChemSingleSelectTask task = ChemSingleSelectTaskFactory.createTask(exampleTask);
        repository.save(task);
        log.info("Добавлена задача с UUID = " + task.getTaskId() );
        return task.getTaskId();
    }

    public Optional<ChemSingleSelectTask> getById(String id) {
        return repository.findById(id);
    }

    public List<ChemSingleSelectTask> getAll() {
        return repository.findAll();
    }

    public List<ChemSingleSelectTask> getAllByChapterId(String chapterId) {
        return repository.getAllByChapterId(chapterId);
    }

    public void update(ChemSingleSelectTask task) {
        log.info("Обновлена задача с UUID = " + task.getTaskId() );
        repository.save(task);
    }

    public void deleteById(String id) {
        log.info("Удалена задачу с UUID = " + id);
        repository.deleteById(id);
    }
}
