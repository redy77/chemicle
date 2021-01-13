package com.chemcool.school.tasks.service;

import com.chemcool.school.tasks.domain.TaskOne;
import com.chemcool.school.tasks.domain.TaskThree;
import com.chemcool.school.tasks.domain.TaskTwo;
import com.chemcool.school.tasks.domain.TypeOfTask;
import com.chemcool.school.tasks.dto.TasksDto;
import com.chemcool.school.tasks.service.TaskOneService;
import com.chemcool.school.tasks.service.TaskThreeService;
import com.chemcool.school.tasks.service.TaskTwoService;
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

    @Autowired
    public TaskThreeService taskThreeService;

    public TasksDto getTaskDtoById(UUID id) {
        TaskOne taskOne = taskOneService.getTaskById(id);
        if (taskOne != null) {
            return new TasksDto(taskOne);
        }
        TaskTwo taskTwo = taskTwoService.getTaskById(id);
        if (taskTwo != null) {
            return new TasksDto(taskTwo);
        }
        TaskThree taskThree = taskThreeService.getTaskById(id);
        if (taskThree != null) {
            return new TasksDto(taskThree);
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
        for (TaskThree task : taskThreeService.getAllTasks()) {
            list.add(new TasksDto(task));
        }
        return list;
    }

    public void add(TasksDto dto) {
        dto.setId( UUID.randomUUID() );//todo заглушка
        if (dto.getTypeOfTask() == TypeOfTask.TASK_1) {
            taskOneService.add(new TaskOne(dto));
        } else if (dto.getTypeOfTask() == TypeOfTask.TASK_2) {
            taskTwoService.add(new TaskTwo(dto));
        } else if (dto.getTypeOfTask() == TypeOfTask.TASK_3) {
            taskThreeService.add(new TaskThree(dto));
        }
    }
}
