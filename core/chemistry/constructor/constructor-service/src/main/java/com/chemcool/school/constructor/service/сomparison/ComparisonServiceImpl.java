package com.chemcool.school.constructor.service.сomparison;

import com.chemcool.school.constructor.domain.сomparison.Comparison;
import com.chemcool.school.constructor.presentation.ComparisonPresentation;
import com.chemcool.school.constructor.storage.ComparisonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComparisonServiceImpl implements ComparisonService {

    private final ComparisonRepository comparisonRepository;
    private final ComparisonConverter comparisonConverter;

    @Autowired
    public ComparisonServiceImpl(ComparisonRepository comparisonRepository, ComparisonConverter comparisonConverter) {
        this.comparisonRepository = comparisonRepository;
        this.comparisonConverter = comparisonConverter;
    }

    @Override
    public String save(ComparisonPresentation comparisonPresentation) {
        Comparison comparison = comparisonConverter.convertPresentationToEntity(comparisonPresentation);
        comparisonRepository.save(comparison);

        return comparison.getTaskId();
    }
}
