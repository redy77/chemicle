package com.chemcool.school.constructor.domain.converters;

import com.chemcool.school.constructor.domain.SingleSelectTask;
import com.chemcool.school.constructor.domain.representation.SingleSelectRepresentation;

public interface SingleSelectConverter {
    SingleSelectTask convertToTask(SingleSelectRepresentation representation);
}
