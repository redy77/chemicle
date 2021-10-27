package com.chemcool.school.constructor.service;

import com.chemcool.school.constructor.domain.Comparison;
import com.chemcool.school.constructor.domain.converters.ComparisonConverter;
import com.chemcool.school.constructor.domain.representation.ComparisonPresentation;
import com.chemcool.school.constructor.infrastructure.storage.ComparisonRepository;
import com.chemcool.school.tasks.statuses.TaskStatus;
import com.chemcool.school.tasks.statuses.TaskType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

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
