package com.chemcool.school.constructor.service;

import com.chemcool.school.constructor.domain.TheoryTask;
import com.chemcool.school.constructor.domain.representation.TheoryTaskRepresentation;

/**
 * @Author : Constantine Lee
 * @Date : 26.10.2021
 * @e-mail : rhowbn@gmail.com
 */
public interface TheoryTaskService {
    String save(TheoryTaskRepresentation representation);
}
