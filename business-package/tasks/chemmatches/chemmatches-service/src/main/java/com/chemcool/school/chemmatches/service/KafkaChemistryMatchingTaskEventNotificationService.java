package com.chemcool.school.chemmatches.service;

import com.chemcool.school.chemmatches.domain.ChemistryMatchingTaskEvent;
import com.chemcool.school.chemmatches.exception.ChemistryMatchingTaskException;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class KafkaChemistryMatchingTaskEventNotificationService implements ChemistryMatchingTaskEventNotificationService {

    private final KafkaTemplate<String, ChemistryMatchingTaskEvent> kafkaTemplate;
    private static final String TOPIC = "tasks-matching";

    @Override
    public void send(ChemistryMatchingTaskEvent event) {
        ListenableFuture<SendResult<String, ChemistryMatchingTaskEvent>> future = kafkaTemplate.send(TOPIC, UUID.randomUUID().toString(), event);
        if (future.isCancelled()) {
            throw new ChemistryMatchingTaskException("Произошла ошибка при записи в кафку");
        }
        kafkaTemplate.flush();
    }
}
