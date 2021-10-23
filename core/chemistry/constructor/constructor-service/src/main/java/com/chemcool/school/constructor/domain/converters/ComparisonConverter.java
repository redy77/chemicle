package com.chemcool.school.constructor.domain.converters;

import com.chemcool.school.constructor.domain.Comparison;
import com.chemcool.school.constructor.domain.representation.ComparisonPresentation;

public interface ComparisonConverter {

    Comparison convertPresentationToEntity(ComparisonPresentation comparisonPresentation);
}
