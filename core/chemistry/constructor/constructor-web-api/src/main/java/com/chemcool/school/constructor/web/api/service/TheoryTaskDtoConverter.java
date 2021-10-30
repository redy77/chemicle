package com.chemcool.school.constructor.web.api.service;

import com.chemcool.school.constructor.domain.representation.TheoryTaskRepresentation;
import com.chemcool.school.constructor.web.api.dto.TheoryTaskDto;

public interface TheoryTaskDtoConverter {
    TheoryTaskRepresentation convertToRepresentation(TheoryTaskDto dto);
}
