package com.chemcool.school.tasks.service;

import com.chemcool.school.tasks.domain.Couple;
import com.chemcool.school.tasks.domain.TaskThree;
import com.chemcool.school.tasks.domain.TypeOfTask;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.UUID.randomUUID;

@Service
public class TaskThreeService {
    private Map<UUID, TaskThree> map = new HashMap<>();

    public TaskThreeService() {
        List<Couple> list = new ArrayList<>();
        list.add( new Couple(UUID.randomUUID().toString(), "Россия", "Москва") );
        list.add( new Couple(UUID.randomUUID().toString(), "США", "Вашингтон") );
        list.add( new Couple(UUID.randomUUID().toString(), "Узбекистан", "Ташкент") );
        list.add( new Couple(UUID.randomUUID().toString(), "Франция", "Париж") );
        UUID id = randomUUID();
        this.map.put(id, new TaskThree( id, "task 31", TypeOfTask.TASK_3, list) );
        id = randomUUID();
        this.map.put(id, new TaskThree( id, "task 32", TypeOfTask.TASK_3, list) );
    }
    public List<TaskThree> getAllTasks() {
        return map.values().stream().collect(Collectors.toList());
    }

    public TaskThree getTaskById(UUID id) {
        return map.get(id);
    }

    public void add(TaskThree task) {
        map.put(task.getId(), task);
    }

}
