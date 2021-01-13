package com.chemcool.school.tasks.web.api.controllers;

import com.chemcool.school.tasks.dto.TasksDto;
import com.chemcool.school.tasks.service.TaskDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class ChemistryTaskRestController {

    @Autowired
    private TaskDtoService service;

    @GetMapping
    public List<TasksDto> getAllTasks() {
        return service.getAllTasks();
    }

    @GetMapping("/{id}")
    public TasksDto getTaskById(@PathVariable UUID id) {
        return service.getTaskDtoById(id);
    }

    @PostMapping
    public String createNewTask(@RequestBody TasksDto task) {
        service.add(task);
        return "new task UUID: " + task.getId(); //todo убрать заглушку
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello Task!";
    }

}
