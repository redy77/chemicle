package com.chemcool.school.constructor.service;

import com.chemcool.school.constructor.convertor.FixedAnswerDtoConverter;

import com.chemcool.school.constructor.domain.FixedAnswerTask;
import com.chemcool.school.constructor.representation.FixedAnswerDtoRepresentation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class FixedAnswerServiceLayer {

    private FixedCrudService fixedCrudService;
    private FixedAnswerDtoConverter fixedAnswerDtoConverter;
    private FixedProducerService fixedProducerService;

    public String saveBdConverter(FixedAnswerDtoRepresentation fixedAnswerDtoRepresentation) {
        FixedAnswerTask fixedAnswerTask = fixedAnswerDtoConverter.convertToTask(fixedAnswerDtoRepresentation);
        fixedProducerService.producer(fixedAnswerTask);
        fixedCrudService.addQuestion(fixedAnswerTask);
        return fixedAnswerTask.getTaskId();
    }
}
