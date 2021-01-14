package com.chemcool.school.tasks.service;

import com.chemcool.school.tasks.domain.TaskTwo;
import com.chemcool.school.tasks.domain.TypeOfTask;
import org.springframework.stereotype.Service;

import java.util.*;
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

    public List<TaskTwo> getAll() {
        return map.values().stream().collect(Collectors.toList());
    }

    public Optional<TaskTwo> getById(UUID id) {
        return Optional.ofNullable( map.get(id) );
    }

    public UUID add(TaskTwo task) {
        task.setId( UUID.randomUUID() );
        map.put(task.getId(), task);
        return task.getId();
    }
}
