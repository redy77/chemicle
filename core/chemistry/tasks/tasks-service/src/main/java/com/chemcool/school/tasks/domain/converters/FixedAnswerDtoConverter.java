package com.chemcool.school.tasks.domain.converters;


import com.chemcool.school.tasks.domain.FixedAnswerTask;
import com.chemcool.school.tasks.domain.representation.FixedAnswerDtoRepresentation;

public interface FixedAnswerDtoConverter {
    FixedAnswerTask convertToTask(FixedAnswerDtoRepresentation fixedAnswerDtoRepresentation);
}
