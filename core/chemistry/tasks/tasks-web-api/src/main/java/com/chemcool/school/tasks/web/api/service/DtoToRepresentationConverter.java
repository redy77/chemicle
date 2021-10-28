package com.chemcool.school.tasks.web.api.service;

import com.chemcool.school.tasks.domain.representations.SingleSelectRepresentation;
import com.chemcool.school.tasks.web.api.dto.SingleSelectDto;

/**
 * @Author : Constantine Lee
 * @Date : 28.10.2021
 * @e-mail : rhowbn@gmail.com
 */
public interface DtoToRepresentationConverter {
    SingleSelectRepresentation toRepresentation(SingleSelectDto dto);
}
