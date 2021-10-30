package com.chemcool.school.constructor.web.api.controllers;

import com.chemcool.school.constructor.service.TheoryTaskService;
import com.chemcool.school.constructor.web.api.dto.TheoryTaskDto;
import com.chemcool.school.constructor.web.api.service.TheoryTaskDtoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1.0/theory")
public class TheoryTaskController {

    private final TheoryTaskService service;
    private final TheoryTaskDtoConverter converter;

    @PostMapping("/build")
    public ResponseEntity<String> build(@RequestBody @Valid TheoryTaskDto dto) {
        String id = service.save(converter.convertToRepresentation(dto));
        return ResponseEntity.ok(id);
    }
}
