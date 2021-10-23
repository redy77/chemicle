package com.chemcool.school.constructor.web.api.service;

import com.chemcool.school.constructor.domain.representation.ComparisonPresentation;
import com.chemcool.school.constructor.web.api.dto.ComparisonDto;

public interface ComparisonDtoConverter {

    ComparisonPresentation convertComparisonDtoToPresentation(ComparisonDto comparisonDto);
}
