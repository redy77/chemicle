package com.chemcool.school.lesson.service;


import com.chemcool.school.lesson.domain.ChemistryLessonEvent;
import com.chemcool.school.lesson.exception.ChemistryLessonDefinitionException;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class KafkaChemistryLessonEventNotificationService implements ChemistryLessonEventNotificationService {
    private final KafkaTemplate<String, ChemistryLessonEvent> kafkaTemplate;
    private static final String TOPIC ="chemistry-lesson";

    @Override
    public void send(ChemistryLessonEvent event) {
        ListenableFuture<SendResult<String,ChemistryLessonEvent>> future = kafkaTemplate.send(TOPIC, UUID.randomUUID().toString(),event);
        if (future.isCancelled()){
        throw new ChemistryLessonDefinitionException("Произошла ошибка при записи в кафку");
        }
        kafkaTemplate.flush();
    }
}

