package com.chemcool.school.constructor.service.impls;

import com.chemcool.school.constructor.domain.Comparison;
import com.chemcool.school.constructor.domain.converters.ComparisonConverter;
import com.chemcool.school.constructor.domain.representation.ComparisonPresentation;
import com.chemcool.school.constructor.infrastructure.api.event.KafkaProducerService;
import com.chemcool.school.constructor.infrastructure.storage.ComparisonRepository;
import com.chemcool.school.constructor.service.ComparisonService;
import com.chemcool.school.tasks.statuses.TaskStatus;
import com.chemcool.school.tasks.statuses.TaskType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ComparisonServiceImpl implements ComparisonService {

    private final ComparisonRepository comparisonRepository;
    private final ComparisonConverter comparisonConverter;
    private final KafkaProducerService kafkaProducerService;

    @Autowired
    public ComparisonServiceImpl(ComparisonRepository comparisonRepository, ComparisonConverter comparisonConverter, KafkaProducerService kafkaProducerService) {
        this.comparisonRepository = comparisonRepository;
        this.comparisonConverter = comparisonConverter;
        this.kafkaProducerService = kafkaProducerService;
    }

    @Override
    public String save(ComparisonPresentation comparisonPresentation) {
        Comparison comparison = comparisonConverter.convertPresentationToEntity(comparisonPresentation);
        String generatedId = UUID.randomUUID().toString();

        comparison.setTaskId(generatedId);
        comparison.setTaskType(TaskType.COMPARISON);
        comparison.setTaskStatus(TaskStatus.CREATE);
        comparison.setIsHidden(false);
        comparisonRepository.save(comparison);

        kafkaProducerService.sendToKafka("tasks", comparison);

        return comparison.getTaskId();
    }
}
