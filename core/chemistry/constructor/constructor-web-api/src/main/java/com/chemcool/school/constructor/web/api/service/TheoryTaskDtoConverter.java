package com.chemcool.school.constructor.web.api.service;

import com.chemcool.school.constructor.domain.representation.TheoryTaskRepresentation;
import com.chemcool.school.constructor.web.api.dto.TheoryTaskDto;

/**
 * @Author : Constantine Lee
 * @Date : 26.10.2021
 * @e-mail : rhowbn@gmail.com
 */
public interface TheoryTaskDtoConverter {
    TheoryTaskRepresentation convertToRepresentation(TheoryTaskDto dto);
}
