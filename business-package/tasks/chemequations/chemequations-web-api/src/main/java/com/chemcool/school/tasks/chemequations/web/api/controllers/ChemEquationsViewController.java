package com.chemcool.school.tasks.chemequations.web.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/equations/v.1.0")
@RequiredArgsConstructor
public class ChemEquationsViewController {


    @GetMapping("/view")
    public String viewPage (){
        return "index";
    }

    @GetMapping("/create")
    public String createNewTaskPage (){
        System.out.println();
        return "createNewTask";
    }
}
