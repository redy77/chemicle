package com.chemcool.school.tasks.web.api.service;

import com.chemcool.school.tasks.domain.TypeOfTask;
import com.chemcool.school.tasks.web.api.dto.TasksDto;
import com.chemcool.school.tasks.web.api.exception.ChemistryTaskEmptyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
        Optional<TaskOne> taskOne = taskOneService.getById(id);
        if (taskOne.isPresent()) {
            return new TasksDto( taskOne.get() );
        }
        Optional<TaskTwo> taskTwo = taskTwoService.getById(id);
        if (taskTwo.isPresent()) {
            return new TasksDto( taskTwo.get() );
        }
        Optional<TaskThree> taskThree = taskThreeService.getById(id);
        if (taskThree.isPresent()) {
            return new TasksDto( taskThree.get() );
        }
        return null;
    }

    public List<TasksDto> getAllTasks() {
        List<TasksDto> list = new ArrayList<>();
        for (TaskOne task : taskOneService.getAll()) {
            list.add(new TasksDto(task));
        }
        for (TaskTwo task : taskTwoService.getAll()) {
            list.add(new TasksDto(task));
        }
        for (TaskThree task : taskThreeService.getAll()) {
            list.add(new TasksDto(task));
        }
        return list;
    }

    public void add(TasksDto dto) {
        if( dto.getTypeOfTask().isEmpty() ) {
            throw new ChemistryTaskEmptyException("");
        }

        dto.setId( UUID.randomUUID() );//todo заглушка

        TypeOfTask type = dto.getTypeOfTask().get();
        if (type == TypeOfTask.TASK_1) {
            taskOneService.add(new TaskOne(
                    dto.getId(),
                    dto.getDescription(),
                    type,
                    dto.getOne()
            ));
        } else if (type == TypeOfTask.TASK_2) {
            taskTwoService.add(new TaskTwo(
                    dto.getId(),
                    dto.getDescription(),
                    type,
                    dto.getTwo1(),
                    dto.getTwo2())
            );
        } else if (type == TypeOfTask.TASK_3) {
            taskThreeService.add(new TaskThree(
                    dto.getId(),
                    dto.getDescription(),
                    type,
                    dto.getList()
            ));
        }
    }
}
