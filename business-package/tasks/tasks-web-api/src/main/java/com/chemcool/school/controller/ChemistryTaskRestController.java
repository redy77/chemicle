package com.chemcool.school.controller;

import com.chemcool.school.domain.ChemistryTask;
import com.chemcool.school.domain.TaskOne;
import com.chemcool.school.domain.TaskTwo;
import com.chemcool.school.domain.TaskType;
import com.chemcool.school.service.ChemistryTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@RestController
@RequestMapping("/tasks")
public class ChemistryTaskRestController {

    @Autowired
    private ChemistryTaskService service;

    @GetMapping
    public List<ChemistryTask> getTask() {
        List<ChemistryTask> list = new ArrayList<>();
        list.add( new TaskOne( randomUUID(), "qwerty", "one", TaskType.TASK_1) );
        list.add( new TaskTwo( randomUUID(), "qwerty", "two", TaskType.TASK_2) );
        return list; //todo убрать заглушку
    }

    @PostMapping
    public ChemistryTask createNewTask(@RequestBody ChemistryTask task){
        ChemistryTask newTask = null;
        if (task.getTaskType() == TaskType.TASK_1) {
            newTask = task;
            ((TaskOne) newTask).setId(randomUUID());
            ((TaskOne) newTask).setOne("one 11");
        } else if (task.getTaskType() == TaskType.TASK_2) {
            newTask = task;
            ((TaskTwo) newTask).setId(randomUUID());
            ((TaskTwo) newTask).setTwo("two 22");
        }
        return newTask; //todo убрать заглушку
    }

}
