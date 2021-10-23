package com.chemcool.school.constructor.web.api.controllers;


import com.chemcool.school.constructor.representation.FixedAnswerDtoRepresentation;
import com.chemcool.school.constructor.service.FixedAnswerServiceLayer;
import com.chemcool.school.constructor.web.api.dto.FixedAnswerDto;
import com.chemcool.school.constructor.web.api.service.FixedAnswerDtoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/fixed")
public class FixedAnswer {

    private final FixedAnswerServiceLayer fixedAnswerServiceLayer;
    private final FixedAnswerDtoConverter fixedAnswerDtoConverter;

    @PostMapping("/build")
    public String fixedAnswer(@RequestBody FixedAnswerDto fixedDto) {
        FixedAnswerDtoRepresentation fixedAnswerDtoRepresentation = fixedAnswerDtoConverter.convert(fixedDto);
        return fixedAnswerServiceLayer.saveBdConverter(fixedAnswerDtoRepresentation);
    }


}




