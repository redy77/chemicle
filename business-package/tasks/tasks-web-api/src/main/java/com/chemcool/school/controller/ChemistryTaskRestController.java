package com.chemcool.school.controller;

import com.chemcool.school.domain.ChemistryTask;
import com.chemcool.school.domain.TaskOne;
import com.chemcool.school.domain.TaskTwo;
import com.chemcool.school.domain.TypeOfTask;
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
        list.add( new TaskOne( randomUUID(), "qwerty", TypeOfTask.TASK_1, "one") );
        list.add( new TaskTwo( randomUUID(), "qwerty", TypeOfTask.TASK_2, "two", "2") );
        return list; //todo убрать заглушку
    }

    @PostMapping
    public String createNewTask(
            @RequestBody String json //Получаем json в "сыром" виде без дессириализации в объект
    ) throws JsonProcessingException {
        // Использую Jackson, который уже использует Spring
        JacksonJsonParser jsonParser = new JacksonJsonParser();
        // json -> HashMap
        Map<String, Object> map = jsonParser.parseMap(json);
        // Читаею значение поля taskType общее для всех классов
        String type = (String) map.get("taskType");

        // Сравнение на равенство типу TypeOfTask.TASK_1
        if ( type.equals( TypeOfTask.TASK_1.toString() ) ) {
            // дессириализация в инстанс TaskOne
            ObjectMapper objectMapper = new ObjectMapper();
            TaskOne task = objectMapper.readValue(json, TaskOne.class);
            // какая-то бизнес логика в сервисе
            task.setId( UUID.randomUUID() );
            task.setOne( task.getOne() + "1");
            return "====== " + task;
        }
        // И т.д...

        return "newTask " + json; //todo убрать заглушку
    }

}
