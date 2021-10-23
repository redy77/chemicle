package com.chemcool.school.constructor.domain.converters;

import com.chemcool.school.constructor.domain.FixedAnswerTask;
import com.chemcool.school.constructor.domain.representation.FixedAnswerDtoRepresentation;

public interface FixedAnswerDtoConverter {
    FixedAnswerTask convertToTask(FixedAnswerDtoRepresentation fixedAnswerDtoRepresentation);
}
