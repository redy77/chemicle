package com.chemcool.school.constructor.domain.converters;

import com.chemcool.school.constructor.domain.TheoryTask;
import com.chemcool.school.constructor.domain.representation.TheoryTaskRepresentation;

/**
 * @Author : Constantine Lee
 * @Date : 26.10.2021
 * @e-mail : rhowbn@gmail.com
 */
public interface TheoryTaskConverter {
    TheoryTask convertToTask(TheoryTaskRepresentation representation);
}
