package com.chemcool.school.constructor.web.api.controllers;


import com.chemcool.school.constructor.domain.representation.FixedAnswerDtoRepresentation;
import com.chemcool.school.constructor.service.FixedAnswerServiceLayer;
import com.chemcool.school.constructor.web.api.dto.FixedAnswerDto;
import com.chemcool.school.constructor.web.api.service.FixedAnswerDtoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequiredArgsConstructor
@RestController
@RequestMapping("/v1.0/fixed-answer")
public class FixedAnswerController {

    private final FixedAnswerServiceLayer fixedAnswerServiceLayer;
    private final FixedAnswerDtoConverter fixedAnswerDtoConverter;

    @PostMapping("/build")
    public String fixedAnswer(@RequestBody @Valid FixedAnswerDto fixedDto) {
        FixedAnswerDtoRepresentation fixedAnswerDtoRepresentation = fixedAnswerDtoConverter.convert(fixedDto);
        return fixedAnswerServiceLayer.saveBdConverter(fixedAnswerDtoRepresentation);
    }


}




