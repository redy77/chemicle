package com.chemcool.school.constructor.web.api.dto;

import com.chemcool.school.constructor.presentation.ComparisonPresentation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComparisonDtoConverter {

    private ModelMapper modelMapper;

    @Autowired
    public ComparisonDtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ComparisonPresentation convertComparisonDtoToPresentation(ComparisonDto comparisonDto) {
        return modelMapper.map(comparisonDto, ComparisonPresentation.class);
    }
}
