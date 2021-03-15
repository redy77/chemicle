package com.chemcool.school.lesson.tasks.chemequations.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.chemcool.school.lesson.tasks.chemequations.domain.*;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class ChemEquationsTaskProxyService {


    private final ChemEquationsTaskEventNotificationService notificationService;
    private final ChemEquationsTaskService taskService;

    public String add(ChemEquationsTaskExample exampleTask) {
        ChemEquationsTask task = ChemEquationsTaskFactory.createChemEquationsTask(exampleTask);
        notificationService.send(ChemEquationsTaskEventFactory.createTaskEvent(task, ChemEquationsTaskEventType.CREATE));
        return task.getTaskId();
    }

    public void update(ChemEquationsTask task) {
        notificationService.send(ChemEquationsTaskEventFactory.createTaskEvent(task, ChemEquationsTaskEventType.UPDATE));
    }

    public Optional<ChemEquationsTask> getById(String id) {
        return taskService.getById(id);
    }

    public List<ChemEquationsTask> getAll() {
        return taskService.getAll();
    }

    public List<ChemEquationsTask> getAllByChapterId(int chapterId) {
        return taskService.getAllByChapterId(chapterId);
    }

    public void deleteById(String id) {
        taskService.deleteById(id);
    }


}

/*
public class ChemSingleSelectTaskProxyService {
    public Optional<ChemSingleSelectTask> getById(String id) {
        return taskService.getById(id);
    }

    public List<ChemSingleSelectTask> getAll() {
        return taskService.getAll();
    }

    public List<ChemSingleSelectTask> getAllByChapterId(int chapterId) {
        return taskService.getAllByChapterId(chapterId);
   }

    public void deleteById(String id) {
        taskService.deleteById(id);
    }
}

 */