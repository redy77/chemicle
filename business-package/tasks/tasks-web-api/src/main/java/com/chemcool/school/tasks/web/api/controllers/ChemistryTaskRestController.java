package com.chemcool.school.tasks.web.api.controllers;

import com.chemcool.school.tasks.web.api.dto.TasksDto;
import com.chemcool.school.tasks.web.api.service.TaskDtoService;
import io.swagger.annotations.ApiOperation;
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
    public TasksDto getTaskById(@PathVariable String id) {
        return service.getTaskDtoById(id);
    }

    @PostMapping
    @ApiOperation("Создает задание для одной из четырех сущностей заданий по химии.")
    @ResponseBody
    public String createNewTask(@RequestBody TasksDto task) {
        service.add(task);
        return "new task UUID: " + task.getId(); //todo убрать заглушку
    }

    @GetMapping("/hello")
    @ApiOperation("Просто тестовый Hello.")
    public String hello() {
        return "Hello Task!";
    }

}
