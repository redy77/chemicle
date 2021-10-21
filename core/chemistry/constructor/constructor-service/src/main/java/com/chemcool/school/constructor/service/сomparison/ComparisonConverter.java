package com.chemcool.school.constructor.service.сomparison;

import com.chemcool.school.constructor.domain.Comparison;
import com.chemcool.school.constructor.domain.ComparisonPair;
import com.chemcool.school.constructor.presentation.ComparisonPresentation;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class ComparisonConverter {

    private final ModelMapper modelMapper;
    private final Converter<HashMap<String, String>, List<ComparisonPair>> hashMapToList = mappingContext -> {
        ComparisonPresentation presentation = (ComparisonPresentation) mappingContext.getParent().getSource();
        HashMap<String, String> correctAnswers = presentation.getCorrectAnswers();
        List<ComparisonPair> comparisonPairs = new ArrayList<>();

        correctAnswers.forEach((leftValue, rightValue) -> {
            ComparisonPair comparisonPair = new ComparisonPair();

            comparisonPair.setLeftValue(leftValue);
            comparisonPair.setRightValue(rightValue);

            comparisonPairs.add(comparisonPair);
        });

        return comparisonPairs;
    };

    @Autowired
    public ComparisonConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Comparison convertPresentationToEntity(ComparisonPresentation comparisonPresentation) {
        modelMapper
                .createTypeMap(ComparisonPresentation.class, Comparison.class)
                .addMappings(mapper -> mapper.using(hashMapToList)
                    .map(ComparisonPresentation::getCorrectAnswers, Comparison::setComparisonPairs)
                );

        return modelMapper.map(comparisonPresentation, Comparison.class);
    }
}
