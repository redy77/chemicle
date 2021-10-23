package com.chemcool.school.constructor.convertor;

import com.chemcool.school.constructor.domain.FixedAnswerTask;
import com.chemcool.school.constructor.representation.FixedAnswerDtoRepresentation;

public interface FixedAnswerDtoConverter {
    FixedAnswerTask convertToTask(FixedAnswerDtoRepresentation fixedAnswerDtoRepresentation);
}
