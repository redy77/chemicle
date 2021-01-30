package com.chemcool.school.tasks.chemsingleselect.service;


import com.chemcool.school.tasks.chemsingleselect.domain.ChemistrySingleSelectTask;
import com.chemcool.school.tasks.chemsingleselect.domain.ChemistrySingleSelectTaskExample;
import com.chemcool.school.tasks.chemsingleselect.domain.ChemistrySingleSelectTaskFactory;
import com.chemcool.school.tasks.chemsingleselect.storage.ChemistrySingleSelectTaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChemistrySingleSelectTaskService implements ChemistryTaskService<ChemistrySingleSelectTask, ChemistrySingleSelectTaskExample> {

    private final ChemistrySingleSelectTaskRepository repository;

    @Override
    public String add(ChemistrySingleSelectTaskExample exampleTask) {
        ChemistrySingleSelectTask task = ChemistrySingleSelectTaskFactory.createTask(exampleTask);
        repository.save(task);
        log.info("Добавление сущности задания " + task.getClass().getName() +
                " прошло  успешно. UUID = " + task.getChemistrySingleSelectTaskUuid() );
        return task.getChemistrySingleSelectTaskUuid();
    }

    @Override
    public Optional<ChemistrySingleSelectTask> getById(String id) {
        log.info("Ищем сущность задания ChemistrySingleSelectTask по UUID = " + id);
        return repository.findById(id);
    }

    @Override
    public List<ChemistrySingleSelectTask> getAll() {
        log.info("Ищем все сущности заданий ChemistrySingleSelectTask.");
        return repository.findAll();
    }

    @Override
    public List<ChemistrySingleSelectTask> getAllByChapterId(String chapterId) {
        log.info("Ищем все сущности заданий ChemistrySingleSelectTask по chapterID = " + chapterId);
        return repository.getAllByChapterId(chapterId);
    }

    @Override
    public void update(ChemistrySingleSelectTask task) {
        repository.save(task);
        log.info("Обновление сущности задания " + this.getClass().getName() +
                " прошло  успешно. UUID = " + task.getChemistrySingleSelectTaskUuid() );
    }

    @Override
    public void deleteById(String id) {
        log.info("Удаляем сущность задания ChemistrySingleSelectTask.");
        repository.deleteById(id);
    }
}
