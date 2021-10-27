package com.chemcool.school.constructor.service.impls;

import com.chemcool.school.constructor.domain.converters.FixedAnswerDtoConverter;

import com.chemcool.school.constructor.domain.FixedAnswerTask;
import com.chemcool.school.constructor.domain.representation.FixedAnswerDtoRepresentation;
import com.chemcool.school.constructor.infrastructure.api.event.KafkaProducerService;
import com.chemcool.school.constructor.service.FixedCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class FixedAnswerServiceLayer {

    private final FixedCrudService fixedCrudService;
    private final FixedAnswerDtoConverter fixedAnswerDtoConverter;
    private final KafkaProducerService kafkaProducerService;

    public String saveBdConverter(FixedAnswerDtoRepresentation fixedAnswerDtoRepresentation) {
        FixedAnswerTask fixedAnswerTask = fixedAnswerDtoConverter.convertToTask(fixedAnswerDtoRepresentation);
        fixedCrudService.addQuestion(fixedAnswerTask);
        kafkaProducerService.sendToKafka("tasks", fixedAnswerTask);
        return fixedAnswerTask.getTaskId();
    }
}
