package com.chemcool.school.tasks.service;

import com.chemcool.school.tasks.domain.TaskOne;
import com.chemcool.school.tasks.domain.TypeOfTask;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.UUID.randomUUID;

@Service
public class TaskOneService {// implements TaskService<TaskOne> {
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
//    @Override
    public List<TaskOne> getAll() {
        return map.values().stream().collect(Collectors.toList());
    }
//    @Override
    public Optional<TaskOne> getById(UUID id) {
        return Optional.ofNullable( map.get(id) );
    }

    public void add(TaskOne task) {
        map.put(task.getId(), task);
    }

}
