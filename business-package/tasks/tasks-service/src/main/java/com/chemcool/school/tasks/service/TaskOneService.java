package com.chemcool.school.tasks.service;

import com.chemcool.school.tasks.domain.TaskOne;
import com.chemcool.school.tasks.domain.TypeOfTask;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.UUID.randomUUID;

@Service
public class TaskOneService {
    private Map<UUID, TaskOne> map = new HashMap<>();

    public TaskOneService() {
        UUID id = randomUUID();
        this.map.put(id, new TaskOne( id, "task 11", TypeOfTask.TASK_1, "one") );
        id = randomUUID();
        this.map.put(id, new TaskOne( id, "task 12", TypeOfTask.TASK_1, "one") );
        id = randomUUID();
        this.map.put(id, new TaskOne( id, "task 13", TypeOfTask.TASK_1, "one") );
        id = randomUUID();
        this.map.put(id, new TaskOne( id, "task 14", TypeOfTask.TASK_1, "one") );
    }
    public List<TaskOne> getAllTasks() {
        return map.values().stream().collect(Collectors.toList());
    }

    public TaskOne getTaskById(UUID id) {
        return map.get(id);
    }

    public void add(TaskOne task) {
        map.put(task.getId(), task);
    }

}
