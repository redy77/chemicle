package com.chemcool.school.tasks.web.api.service;

import com.chemcool.school.tasks.web.api.domain.TaskOne;
import com.chemcool.school.tasks.web.api.domain.TaskTwo;
import com.chemcool.school.tasks.web.api.domain.TypeOfTask;
import com.chemcool.school.tasks.web.api.dto.TasksDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TaskDtoService {

    @Autowired
    public TaskOneService taskOneService;

    @Autowired
    public TaskTwoService taskTwoService;

    public TasksDto getTaskDtoById(UUID id) {
        TaskOne taskOne = taskOneService.getTaskById(id);
        if (taskOne != null) {
            return new TasksDto(taskOne);
        }
        TaskTwo taskTwo = taskTwoService.getTaskById(id);
        if (taskTwo != null) {
            return new TasksDto(taskTwo);
        }
        return null; //todo return null, возможно поменять на выброс ексепшна
    }

    public List<TasksDto> getAllTasks() {
        List<TasksDto> list = new ArrayList<>();
        for (TaskOne task : taskOneService.getAllTasks()) {
            list.add(new TasksDto(task));
        }
        for (TaskTwo task : taskTwoService.getAllTasks()) {
            list.add(new TasksDto(task));
        }
        return list;
    }

    public void add(TasksDto task) {
        task.setId( UUID.randomUUID() );
        if (task.getTypeOfTask() == TypeOfTask.TASK_1) {
            taskOneService.add(new TaskOne(task));
        } else if (task.getTypeOfTask() == TypeOfTask.TASK_2) {
            taskTwoService.add(new TaskTwo(task));
        }
    }
}
