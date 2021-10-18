package com.chemcool.school.constructor.service.сomparison;

import com.chemcool.school.constructor.domain.сomparison.Comparison;
import com.chemcool.school.constructor.storage.ComparisonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComparisonServiceImpl implements ComparisonService {

    private final ComparisonRepository comparisonRepository;

    @Autowired
    public ComparisonServiceImpl(ComparisonRepository comparisonRepository) {
        this.comparisonRepository = comparisonRepository;
    }

    @Override
    public void save(Comparison comparison) {
        comparisonRepository.save(comparison);
    }
}
