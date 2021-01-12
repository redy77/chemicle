package com.chemcool.school.tasks.web.api.controller;

import com.chemcool.school.tasks.web.api.domain.TaskOne;
import com.chemcool.school.tasks.web.api.domain.TaskTwo;
import com.chemcool.school.tasks.web.api.domain.TypeOfTask;
import com.chemcool.school.tasks.web.api.dto.TasksDto;
import com.chemcool.school.tasks.web.api.service.TaskDtoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static java.util.UUID.randomUUID;

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
