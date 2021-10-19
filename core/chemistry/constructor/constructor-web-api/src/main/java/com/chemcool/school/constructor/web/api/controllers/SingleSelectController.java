package com.chemcool.school.constructor.web.api.controllers;

import com.chemcool.school.constructor.service.SingleSelectService;
import com.chemcool.school.constructor.web.api.dto.SingleSelectDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/single-select")
public class SingleSelectController {

    private final SingleSelectService service;

    @Autowired
    public SingleSelectController(SingleSelectService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String test() {
        return "working";
    }

    @PostMapping("/")
    public ResponseEntity<SingleSelectDto> add(@RequestBody SingleSelectDto dto) {
        service.save(dto.dtoToEntity(dto));
        return ResponseEntity.ok(dto);
    }


}
