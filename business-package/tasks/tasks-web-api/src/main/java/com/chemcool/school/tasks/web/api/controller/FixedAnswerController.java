package com.chemcool.school.tasks.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/v1.0/tasks"})
public class FixedAnswerController {


    @GetMapping("/hello")
    public String getHello() {
        return "Hello TasksController";
    }
}
