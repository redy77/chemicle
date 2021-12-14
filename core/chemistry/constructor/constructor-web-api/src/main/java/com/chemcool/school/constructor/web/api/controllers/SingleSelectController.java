package com.chemcool.school.constructor.web.api.controllers;

import com.chemcool.school.constructor.service.SingleSelectService;
import com.chemcool.school.constructor.web.api.dto.SingleSelectDto;
import com.chemcool.school.constructor.web.api.service.SingleSelectDtoConverter;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1.0/single-select")
@RequiredArgsConstructor
public class    SingleSelectController {

    private final SingleSelectService service;
    private final SingleSelectDtoConverter converter;

    @PostMapping("/build")
    @ApiOperation(value = "Создание задачи с выбором ответа, при успешном создании возвращает id новой задачи", response = String.class)
    public ResponseEntity<String> build(@RequestBody @Valid SingleSelectDto dto) {
        String id = service.save(converter.convertToRepresentation(dto));
        return ResponseEntity.ok(id);
    }
}

