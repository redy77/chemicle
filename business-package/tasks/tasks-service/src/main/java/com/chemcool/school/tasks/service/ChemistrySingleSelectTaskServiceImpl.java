package com.chemcool.school.tasks.service;

import com.chemcool.school.tasks.domain.ChemistrySingleSelectTask;
import com.chemcool.school.tasks.domain.ChemistrySingleSelectTaskExample;
import com.chemcool.school.tasks.domain.ChemistrySingleSelectTaskFactory;
import com.chemcool.school.tasks.storage.ChemistrySingleSelectTaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChemistrySingleSelectTaskServiceImpl implements ChemistryTaskService<ChemistrySingleSelectTask, ChemistrySingleSelectTaskExample> {

    private final ChemistrySingleSelectTaskRepository repository;

    @Override
    public String add(ChemistrySingleSelectTaskExample exampleTask) {
        ChemistrySingleSelectTask task = ChemistrySingleSelectTaskFactory.createTask(exampleTask);
        repository.save(task);
        log.info("Добавление сущности задания " + this.getClass().getName() +
                " прошло  успешно. UUID = " + task.getChemistrySingleSelectTaskUuid() );
        return task.getChemistrySingleSelectTaskUuid();
    }

    @Override
    public Optional<ChemistrySingleSelectTask> getById(String id) {
        log.info("====getById===="); //todo логи
        return repository.findById(id);
    }

    @Override
    public List<ChemistrySingleSelectTask> getAll() {
        log.info("====getAll===="); //todo логи
        return repository.findAll();
    }

    @Override
    public List<ChemistrySingleSelectTask> getAllByChapterId(String chapterId) {
        log.info("====getAllByChapter===="); //todo логи
        return repository.getAllByChapterId(chapterId);
    }

    @Override
    public void update(ChemistrySingleSelectTaskExample exampleTask) {
        ChemistrySingleSelectTask task = ChemistrySingleSelectTaskFactory.createTask(exampleTask);//todo сделал как и add через фабрику, может не нужно?
        task.setChemistrySingleSelectTaskUuid( exampleTask.getChemistrySingleSelectTaskUuid() );
        repository.save(task);
        log.info("Обновление сущности задания " + this.getClass().getName() +
                " прошло  успешно. UUID = " + task.getChemistrySingleSelectTaskUuid() );
    }

    @Override
    public void deleteById(String id) {
        log.info("====delete===="); //todo логи
        repository.deleteById(id);
    }
}
