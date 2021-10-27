package com.chemcool.school.constructor.service.impls;

import com.chemcool.school.constructor.domain.TheoryTask;
import com.chemcool.school.constructor.domain.converters.TheoryTaskConverter;
import com.chemcool.school.constructor.domain.representation.TheoryTaskRepresentation;
import com.chemcool.school.constructor.infrastructure.api.event.KafkaProducerService;
import com.chemcool.school.constructor.infrastructure.storage.TheoryTaskRepository;
import com.chemcool.school.constructor.service.TheoryTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Author : Constantine Lee
 * @Date : 26.10.2021
 * @e-mail : rhowbn@gmail.com
 */
@Service
@RequiredArgsConstructor
public class TheoryTaskServiceImpl implements TheoryTaskService {

    private final TheoryTaskRepository repository;
    private final TheoryTaskConverter converter;
    private final KafkaProducerService kafkaProducerService;

    @Override
    public String save(TheoryTaskRepresentation representation) {
        TheoryTask task = converter.convertToTask(representation);
        String id = task.getTaskId();
        repository.save(task);

        kafkaProducerService.sendToKafka("theory", task);
        return id;
    }
}
