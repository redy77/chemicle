package com.chemcool.school.constructor.web.api.controllers;

import com.chemcool.school.constructor.domain.сomparison.Comparison;
import com.chemcool.school.constructor.service.сomparison.ComparisonService;
import com.chemcool.school.constructor.service.сomparison.ComparisonConverter;
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

    @Autowired
    public ComparisonController(ComparisonService comparisonService) {
        this.comparisonService = comparisonService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> add(@RequestBody @Valid ComparisonDto comparisonDto) {
        String id = comparisonService.save(comparisonDto.toPresentation());

        return ResponseEntity.ok(id);
    }
}
