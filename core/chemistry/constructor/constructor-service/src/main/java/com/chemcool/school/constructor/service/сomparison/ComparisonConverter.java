package com.chemcool.school.constructor.service.сomparison;

import com.chemcool.school.constructor.domain.сomparison.Comparison;
import com.chemcool.school.constructor.domain.сomparison.ComparisonPair;
import com.chemcool.school.constructor.domain.сomparison.ComparisonStatement;
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
        List<String> keys = presentation.getKeys();
        List<String> values = presentation.getValues();
        HashMap<String, String> mapping = presentation.getMapping();
        List<ComparisonPair> items = new ArrayList<>();

        mapping.forEach((key, value) -> {
            int keyIndex = keys.indexOf(key);
            int valueIndex = values.indexOf(value);

            if (keyIndex == -1 || valueIndex == -1) {
                //TODO Customize exception
                throw new RuntimeException("Invalid request");
            }

            ComparisonStatement keyStatement = new ComparisonStatement(key, keyIndex);
            ComparisonStatement valueStatement = new ComparisonStatement(value, valueIndex);

            ComparisonPair comparisonPair = new ComparisonPair();
            comparisonPair.setKey(keyStatement);
            comparisonPair.setValue(valueStatement);

            items.add(comparisonPair);
        });

        return items;
    };

    @Autowired
    public ComparisonConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Comparison convertPresentationToEntity(ComparisonPresentation comparisonPresentation) {
        modelMapper
                .createTypeMap(ComparisonPresentation.class, Comparison.class)
                .addMappings(mapper -> mapper.using(hashMapToList)
                    .map(ComparisonPresentation::getMapping, Comparison::setItems)
                );

        return modelMapper.map(comparisonPresentation, Comparison.class);
    }
}
