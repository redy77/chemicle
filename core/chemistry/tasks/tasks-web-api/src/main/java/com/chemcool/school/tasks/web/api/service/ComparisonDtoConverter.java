package com.chemcool.school.tasks.web.api.service;

import com.chemcool.school.tasks.domain.representation.ComparisonPresentation;
import com.chemcool.school.tasks.web.api.dto.ComparisonDto;

public interface ComparisonDtoConverter {

    ComparisonPresentation convertComparisonDtoToPresentation(ComparisonDto comparisonDto);
}
