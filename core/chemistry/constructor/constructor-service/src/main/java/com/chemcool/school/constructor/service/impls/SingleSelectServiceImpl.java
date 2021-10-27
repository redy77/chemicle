package com.chemcool.school.constructor.service.impls;
/**
 * @Author Constantine Lee
 */

import com.chemcool.school.constructor.domain.converters.SingleSelectConverter;
import com.chemcool.school.constructor.domain.representation.SingleSelectRepresentation;
import com.chemcool.school.constructor.domain.SingleSelectTask;
import com.chemcool.school.constructor.infrastructure.api.event.KafkaProducerService;
import com.chemcool.school.constructor.infrastructure.storage.SingleSelectRepository;
import com.chemcool.school.constructor.service.SingleSelectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SingleSelectServiceImpl implements SingleSelectService {

    private final SingleSelectRepository repository;
    private final SingleSelectConverter converter;
    private final KafkaProducerService kafkaProducerService;

    @Override
    public String save(SingleSelectRepresentation representation) {
        SingleSelectTask task = converter.convertToTask(representation);
        repository.save(task);
        kafkaProducerService.sendToKafka("tasks", task);
        return task.getTaskId();
    }
}