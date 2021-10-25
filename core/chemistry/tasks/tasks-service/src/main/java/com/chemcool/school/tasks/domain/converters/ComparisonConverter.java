package com.chemcool.school.tasks.domain.converters;


import com.chemcool.school.tasks.domain.Comparison;
import com.chemcool.school.tasks.domain.representation.ComparisonPresentation;

public interface ComparisonConverter {

    Comparison convertPresentationToEntity(ComparisonPresentation comparisonPresentation);
}
