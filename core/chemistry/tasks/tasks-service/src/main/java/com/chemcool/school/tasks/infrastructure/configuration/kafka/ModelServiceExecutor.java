package com.chemcool.school.tasks.infrastructure.configuration.kafka;

import com.chemcool.school.tasks.models.Task;
import com.chemcool.school.tasks.service.TaskService;
import com.chemcool.school.tasks.statuses.TaskStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModelServiceExecutor {

    @Autowired
    private ModelServiceContext modelContext;

    private Task task;
    private TaskService taskService;
    private TaskStatus taskStatus;

    public void execute(Task task) {
        this.task = task;
        this.taskService = modelContext.getTaskService(task.getTaskType());
        this.taskStatus = task.getTaskStatus();
        changeStatus();
    }

    private void changeStatus() {
        switch (taskStatus) {
            case CREATE:
                taskService.create(task);
                break;
            case UPDATE:
                taskService.update(task);
                break;
            case DELETE:
                taskService.delete(task);
                break;
        }
    }
}
