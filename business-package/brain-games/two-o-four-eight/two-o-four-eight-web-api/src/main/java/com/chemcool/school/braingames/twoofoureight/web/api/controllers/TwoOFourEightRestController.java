package com.chemcool.school.braingames.twoofoureight.web.api.controllers;

import com.chemcool.school.braingames.twoofoureight.web.api.jwt.jwtParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class TwoOFourEightRestController {

    private final jwtParser jwtParser;

    @GetMapping()
    public ResponseEntity<String> viewPage(@RequestHeader(value = "Authorization", required = false) String token) {

        return new ResponseEntity<>("this is reply of our token:  "+token, HttpStatus.OK);
    }

    @GetMapping("/test")
    public ModelAndView index (@RequestHeader(value = "AuthorizationToken") String token) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        System.out.println(jwtParser.getIdUserOfToken(token));

        return modelAndView;
    }


}
