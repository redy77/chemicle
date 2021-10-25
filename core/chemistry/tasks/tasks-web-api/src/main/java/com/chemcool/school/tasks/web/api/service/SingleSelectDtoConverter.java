package com.chemcool.school.tasks.web.api.service;
/**
 * @Author Constantine Lee
 */

import com.chemcool.school.tasks.domain.representation.SingleSelectRepresentation;
import com.chemcool.school.tasks.web.api.dto.SingleSelectDto;

public interface SingleSelectDtoConverter {
    SingleSelectRepresentation convertToRepresentation(SingleSelectDto dto);
}
