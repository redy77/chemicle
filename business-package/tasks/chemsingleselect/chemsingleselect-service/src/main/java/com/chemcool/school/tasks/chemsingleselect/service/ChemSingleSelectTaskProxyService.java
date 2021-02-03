package com.chemcool.school.tasks.chemsingleselect.service;

import com.chemcool.school.tasks.chemsingleselect.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChemSingleSelectTaskProxyService {

    private final ChemSingleSelectTaskEventNotificationService notificationService;
    private final ChemSingleSelectTaskService taskService;

    public String add(ChemSingleSelectTaskExample exampleTask) {
        ChemSingleSelectTask task = ChemSingleSelectTaskFactory.createTask(exampleTask);
        ChemSingleSelectTaskEvent event = ChemSingleSelectTaskEvent.createEvent(task, ChemTaskEventType.CREATE);
        notificationService.send(event );
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
        ChemSingleSelectTaskEvent event = ChemSingleSelectTaskEvent.createEvent(task, ChemTaskEventType.UPDATE);
        notificationService.send(event );
    }

    public void deleteById(String id) {
        taskService.deleteById(id);
    }
}
