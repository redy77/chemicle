package com.chemcool.school.constructor.web.api.controllers;
/**
 * @Author Constantine Lee
 */

import com.chemcool.school.constructor.domain.representation.SingleSelectRepresentation;
import com.chemcool.school.constructor.service.SingleSelectService;
import com.chemcool.school.constructor.web.api.dto.SingleSelectDto;
import com.chemcool.school.constructor.web.api.service.SingleSelectConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/single-select")
@RequiredArgsConstructor
public class SingleSelectController {

    private final SingleSelectService service;
    private final SingleSelectConverter convertor;

    @PostMapping("/build")
    public ResponseEntity<String> build(@RequestBody SingleSelectDto dto) {
        SingleSelectRepresentation representation = convertor.convertToRepresentation(dto);
        return ResponseEntity.ok(service.save(representation));
    }
}
