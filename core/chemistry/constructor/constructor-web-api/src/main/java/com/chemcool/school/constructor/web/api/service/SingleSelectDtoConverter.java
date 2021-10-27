package com.chemcool.school.constructor.web.api.service;
/**
 * @Author Constantine Lee
 */

import com.chemcool.school.constructor.domain.representation.SingleSelectRepresentation;
import com.chemcool.school.constructor.web.api.dto.SingleSelectDto;

public interface SingleSelectDtoConverter {
    SingleSelectRepresentation convertToRepresentation(SingleSelectDto dto);
}
