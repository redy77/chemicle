package com.chemcool.school.constructor.web.api.controllers;

import com.chemcool.school.constructor.web.api.dto.ComparisonDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/comparison")
public class ComparisonController {

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<ComparisonDto> add(@RequestBody @Valid ComparisonDto comparisonDto) {
        return ResponseEntity.ok(comparisonDto);
        //return null;
    }
}
