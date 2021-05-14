package com.chemcool.school.games.twoofoureight.web.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/game")
@RequiredArgsConstructor
public class TwoOFourEightController {

    @GetMapping()
    public String viewPage() {
        return "index";
    }

}
