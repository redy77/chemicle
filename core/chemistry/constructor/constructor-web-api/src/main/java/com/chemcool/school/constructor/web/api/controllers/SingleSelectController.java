package com.chemcool.school.constructor.web.api.controllers;

import com.chemcool.school.constructor.domain.SingleSelectPresentation;
import com.chemcool.school.constructor.service.SingleSelectService;
import com.chemcool.school.constructor.web.api.dto.SingleSelectDto;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/single-select")
@NoArgsConstructor
public class SingleSelectController {

    private SingleSelectService service;
    private ModelMapper mapper;

    @PostMapping("/")
    public ResponseEntity<String> add(@RequestBody SingleSelectDto dto) {
        SingleSelectPresentation presentation = mapper.map(dto, SingleSelectPresentation.class);
        return ResponseEntity.ok(service.save(presentation));
    }
}
