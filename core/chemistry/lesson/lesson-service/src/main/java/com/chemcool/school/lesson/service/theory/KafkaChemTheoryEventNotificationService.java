package com.chemcool.school.lesson.service.theory;


import com.chemcool.school.lesson.domain.theory.ChemTheoryEvent;
import com.chemcool.school.lesson.exception.theory.ChemTheoryDefenitionException;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class KafkaChemTheoryEventNotificationService implements ChemTheoryEventNotificationService {

    private final KafkaTemplate<String, ChemTheoryEvent> kafkaTemplate;

    private static final String TOPIC = "chemistry-theory";

    @Override
    public void send(ChemTheoryEvent event) {
        ListenableFuture<SendResult<String, ChemTheoryEvent>> future = kafkaTemplate.send(TOPIC, UUID.randomUUID().toString(), event);
        if (future.isCancelled()){
            throw new ChemTheoryDefenitionException("Произошла ошибка при записи в кафку");
        }
        kafkaTemplate.flush();
    }
}
