package com.chemcool.school.tasks.domain.converters;

import com.chemcool.school.tasks.domain.SingleSelectTask;
import com.chemcool.school.tasks.domain.representation.SingleSelectRepresentation;

/**
 * @Author Constantine Lee
 */



public interface SingleSelectConverter {
    SingleSelectTask convertToTask(SingleSelectRepresentation representation);
}
