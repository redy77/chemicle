package com.chemcool.school.braingames.twoofoureight.web.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/game")
@RequiredArgsConstructor
public class TwoOFourEightController {

    @GetMapping()
    public String viewPage() {
        return "index"; }

}
