package com.chemcool.school.constructor.web.api.service;

import com.chemcool.school.constructor.domain.representation.SingleSelectRepresentation;
import com.chemcool.school.constructor.web.api.dto.SingleSelectDto;
import org.springframework.stereotype.Service;

@Service
public class SingleSelectConverterImpl implements SingleSelectConverter{
    public SingleSelectRepresentation build(SingleSelectDto dto) {
        return SingleSelectDto.build(dto);
    }
}
