package com.chemcool.school.tasks.service;

import com.chemcool.school.tasks.domain.ChemistrySingleSelectTask;
import com.chemcool.school.tasks.domain.ChemistrySingleSelectTaskExample;
import com.chemcool.school.tasks.domain.ChemistrySingleSelectTaskFactory;
import com.chemcool.school.tasks.exeption.ChemistrySingleSelectTaskFormatException;
import com.chemcool.school.tasks.storage.ChemistrySingleSelectTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChemistrySingleSelectTaskServiceImpl {
    private final ChemistrySingleSelectTaskRepository repository;

    public String add(ChemistrySingleSelectTaskExample task) {
        ChemistrySingleSelectTask chemistrySingleSelectTask = ChemistrySingleSelectTaskFactory.createTask(task);
        repository.save(chemistrySingleSelectTask);
        return chemistrySingleSelectTask.getChemistrySingleSelectTaskUuid();
    }

    public Optional<ChemistrySingleSelectTask> getById(String id) {
        return repository.findById(id);
    }

    public List<ChemistrySingleSelectTask> getAll() {
        return repository.findAll();
    }

    public List<ChemistrySingleSelectTask> getAllByChapterId(String chapterId) {
        return repository.getAllByChapterId(chapterId);
    }

    public void update(ChemistrySingleSelectTask chemistrySingleSelectTask) {
        repository.save(chemistrySingleSelectTask);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
