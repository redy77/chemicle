package com.chemcool.school.tasks.web.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : Constantine Lee
 * @Date : 24.10.2021 
 * @e-mail : rhowbn@gmail.com
 */
@RestController
@RequestMapping("/v1.0/single-select")
@RequiredArgsConstructor
public class SingleSelectController {



    @GetMapping("/test")
    public String test() {

        return "ok";
    }
}
