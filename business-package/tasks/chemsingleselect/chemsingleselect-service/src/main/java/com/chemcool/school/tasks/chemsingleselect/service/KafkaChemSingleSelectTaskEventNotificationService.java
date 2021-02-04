package com.chemcool.school.tasks.chemsingleselect.service;

import com.chemcool.school.tasks.chemsingleselect.domain.ChemSingleSelectTask;
import com.chemcool.school.tasks.chemsingleselect.domain.ChemSingleSelectTaskEvent;
import com.chemcool.school.tasks.chemsingleselect.domain.ChemTaskEventType;
import com.chemcool.school.tasks.chemsingleselect.exception.ChemSingleSelectDefinitionException;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class KafkaChemSingleSelectTaskEventNotificationService implements ChemSingleSelectTaskEventNotificationService {

    private final KafkaTemplate<String, ChemSingleSelectTaskEvent> kafkaTemplate;
    private static final String TOPIC = "tasks-single-select";

    @Override
    public void send(ChemSingleSelectTaskEvent event) {
        ListenableFuture<SendResult<String, ChemSingleSelectTaskEvent>> future = kafkaTemplate.send(TOPIC, UUID.randomUUID().toString(), event);
        if (future.isCancelled()) {
            throw new ChemSingleSelectDefinitionException("Произошла ошибка при записи в кафку");
        }
        kafkaTemplate.flush();
    }
}
