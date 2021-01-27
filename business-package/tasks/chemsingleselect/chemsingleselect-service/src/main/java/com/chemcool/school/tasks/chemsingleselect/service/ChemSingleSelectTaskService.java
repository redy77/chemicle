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
        log.info("Добавление сущности задания " + task.getClass().getName() +
                " прошло  успешно. UUID = " + task.getTaskId() );
        return task.getTaskId();
    }

    public Optional<ChemSingleSelectTask> getById(String id) {
        log.info("Ищем сущность задания ChemSingleSelectTask по UUID = " + id);
        return repository.findById(id);
    }

    public List<ChemSingleSelectTask> getAll() {
        log.info("Ищем все сущности заданий ChemSingleSelectTask.");
        return repository.findAll();
    }

    public List<ChemSingleSelectTask> getAllByChapterId(String chapterId) {
        log.info("Ищем все сущности заданий ChemSingleSelectTask по chapterID = " + chapterId);
        return repository.getAllByChapterId(chapterId);
    }

    public void update(ChemSingleSelectTask task) {
        repository.save(task);
        log.info("Обновление сущности задания " + this.getClass().getName() +
                " прошло  успешно. UUID = " + task.getTaskId() );
    }

    public void deleteById(String id) {
        log.info("Удаляем сущность задания ChemSingleSelectTask.");
        repository.deleteById(id);
    }
}
