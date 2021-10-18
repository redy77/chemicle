package com.chemcool.school.constructor.web.api.controllers;

import com.chemcool.school.constructor.domain.сomparison.Comparison;
import com.chemcool.school.constructor.service.сomparison.ComparisonService;
import com.chemcool.school.constructor.web.api.converters.ComparisonConverter;
import com.chemcool.school.constructor.web.api.dto.ComparisonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/comparison")
public class ComparisonController {

    private final ComparisonService comparisonService;
    private final ComparisonConverter comparisonConverter;

    @Autowired
    public ComparisonController(ComparisonService comparisonService, ComparisonConverter comparisonConverter) {
        this.comparisonService = comparisonService;
        this.comparisonConverter = comparisonConverter;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<ComparisonDto> add(@RequestBody @Valid ComparisonDto comparisonDto) {
        Comparison comparison = comparisonConverter.convertDtoToEntity(comparisonDto);
        comparisonService.save(comparison);

        return ResponseEntity.ok(comparisonDto);
    }
}
