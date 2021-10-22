package com.chemcool.school.constructor.web.api.controllers;

import com.chemcool.school.constructor.service.ComparisonService;
import com.chemcool.school.constructor.web.api.dto.ComparisonDto;
import com.chemcool.school.constructor.web.api.service.ComparisonDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1.0/comparison")
public class ComparisonController {

    private final ComparisonService comparisonService;
    private final ComparisonDtoConverter comparisonDtoConverter;

    @Autowired
    public ComparisonController(ComparisonService comparisonService, ComparisonDtoConverter comparisonDtoConverter) {
        this.comparisonService = comparisonService;
        this.comparisonDtoConverter = comparisonDtoConverter;
    }

    @PostMapping(value = "/build")
    public ResponseEntity<String> add(@RequestBody @Valid ComparisonDto comparisonDto) {
        String id = comparisonService.save(comparisonDtoConverter.convertComparisonDtoToPresentation(comparisonDto));

        return ResponseEntity.ok(id);
    }
}
