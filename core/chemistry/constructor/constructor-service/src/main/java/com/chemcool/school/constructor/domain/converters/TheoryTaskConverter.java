package com.chemcool.school.constructor.domain.converters;

import com.chemcool.school.constructor.domain.TheoryTask;
import com.chemcool.school.constructor.domain.representation.TheoryTaskRepresentation;

public interface TheoryTaskConverter {
    TheoryTask convertToTask(TheoryTaskRepresentation representation);
}
