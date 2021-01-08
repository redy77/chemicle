package com.chemcool.school.controller;

import com.chemcool.school.domain.ChemistryTask;
import com.chemcool.school.domain.TaskOne;
import com.chemcool.school.domain.TaskTwo;
import com.chemcool.school.domain.TaskType;
import com.chemcool.school.service.ChemistryTaskService;
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
    private ChemistryTaskService service;

    @GetMapping
    public List<ChemistryTask> getTask() {
        List<ChemistryTask> list = new ArrayList<>();
        list.add( new TaskOne( randomUUID(), "qwerty", "one", TaskType.TASK_1) );
        list.add( new TaskTwo( randomUUID(), "qwerty", "two", TaskType.TASK_2) );
        return list; //todo убрать заглушку
    }

    @PostMapping
    public String createNewTask(@RequestBody String json) throws JsonProcessingException {

        JacksonJsonParser jsonParser = new JacksonJsonParser();
        Map<String, Object> map = jsonParser.parseMap(json);
        String type = (String) map.get("taskType");
        if ( type.equals( TaskType.TASK_1.toString() ) ) {
            ObjectMapper objectMapper = new ObjectMapper();
            TaskOne task = objectMapper.readValue(json, TaskOne.class);
            task.setId( UUID.randomUUID() );
            task.setOne( task.getOne() + "1");
            return "====== " + task;
        }

        return "newTask " + json; //todo убрать заглушку
    }

}
