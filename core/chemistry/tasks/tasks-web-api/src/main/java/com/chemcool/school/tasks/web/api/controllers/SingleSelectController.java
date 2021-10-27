package com.chemcool.school.tasks.web.api.controllers;

import com.chemcool.school.tasks.domain.AbstractTask;
import com.chemcool.school.tasks.models.Task;
import com.chemcool.school.tasks.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author : Constantine Lee
 * @Date : 24.10.2021 
 * @e-mail : rhowbn@gmail.com
 */
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class SingleSelectController {

    private final TaskService taskService;


    @GetMapping()
    public String test() {

        return "ok";
    }

    @GetMapping("/all")
    public List<AbstractTask> showAll() {
        return taskService.findAll();
    }
}
