package com.chemcool.school.tasks.chemsingleselect.service;

import com.chemcool.school.tasks.chemsingleselect.api.event.ChemSingleSelectTaskEventProducer;
import com.chemcool.school.tasks.chemsingleselect.domain.ChemSingleSelectTask;
import com.chemcool.school.tasks.chemsingleselect.domain.ChemSingleSelectTaskExample;
import com.chemcool.school.tasks.chemsingleselect.domain.ChemSingleSelectTaskFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChemSingleSelectTaskProxyService {

    private final ChemSingleSelectTaskEventProducer eventProducer;
    private final ChemSingleSelectTaskService taskService;

    public String add(ChemSingleSelectTaskExample exampleTask) {
        ChemSingleSelectTask task = ChemSingleSelectTaskFactory.createTask(exampleTask);
        eventProducer.save(task);
        return task.getTaskId();
    }

    public Optional<ChemSingleSelectTask> getById(String id) {
        return taskService.getById(id);
    }

    public List<ChemSingleSelectTask> getAll() {
        return taskService.getAll();
    }

    public List<ChemSingleSelectTask> getAllByChapterId(int chapterId) {
        return taskService.getAllByChapterId(chapterId);
    }

    public void update(ChemSingleSelectTask task) {
        eventProducer.update(task);
    }

    public void deleteById(String id) {
        taskService.deleteById(id);
    }
}
