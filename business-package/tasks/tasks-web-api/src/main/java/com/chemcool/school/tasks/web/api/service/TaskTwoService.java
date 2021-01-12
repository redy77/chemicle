package com.chemcool.school.tasks.web.api.service;

import com.chemcool.school.tasks.web.api.domain.TaskOne;
import com.chemcool.school.tasks.web.api.domain.TaskTwo;
import com.chemcool.school.tasks.web.api.domain.TypeOfTask;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.UUID.randomUUID;

@Service
public class TaskTwoService {
    private Map<UUID, TaskTwo> map = new HashMap<>();

    public TaskTwoService() {
        UUID id = randomUUID();
        this.map.put(id, new TaskTwo( id, "task 21", TypeOfTask.TASK_2, "two", "2") );
        id = randomUUID();
        this.map.put(id, new TaskTwo( id, "task 22", TypeOfTask.TASK_2, "two", "2") );
        id = randomUUID();
        this.map.put(id, new TaskTwo( id, "task 23", TypeOfTask.TASK_2, "two", "2") );
        id = randomUUID();
        this.map.put(id, new TaskTwo( id, "task 24", TypeOfTask.TASK_2, "two", "2") );
    }

    public List<TaskTwo> getAllTasks() {
        return map.values().stream().collect(Collectors.toList());
    }

    public TaskTwo getTaskById(UUID id) {
        return map.get(id);
    }

    public void add(TaskTwo task) {
        map.put(task.getId(), task);
    }
}
