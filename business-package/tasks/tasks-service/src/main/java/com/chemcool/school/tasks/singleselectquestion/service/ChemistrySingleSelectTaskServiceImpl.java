package com.chemcool.school.tasks.singleselectquestion.service;

import com.chemcool.school.tasks.singleselectquestion.domain.ChemistrySingleSelectTask;
import com.chemcool.school.tasks.singleselectquestion.domain.ChemistrySingleSelectTaskExample;
import com.chemcool.school.tasks.singleselectquestion.domain.ChemistrySingleSelectTaskFactory;
import com.chemcool.school.tasks.singleselectquestion.storage.ChemistrySingleSelectTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
