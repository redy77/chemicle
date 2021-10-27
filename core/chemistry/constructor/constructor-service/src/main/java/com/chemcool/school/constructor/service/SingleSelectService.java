package com.chemcool.school.constructor.service;
/**
 * @Author Constantine Lee
 */

import com.chemcool.school.constructor.domain.representation.SingleSelectRepresentation;

public interface SingleSelectService {
    String save(SingleSelectRepresentation presentation); //returns task id
}
