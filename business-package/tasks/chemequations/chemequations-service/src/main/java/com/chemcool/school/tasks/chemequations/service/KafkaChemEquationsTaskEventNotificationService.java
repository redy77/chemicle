package com.chemcool.school.tasks.chemequations.service;

import com.chemcool.school.tasks.chemequations.domain.ChemCompoundEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class KafkaChemEquationsTaskEventNotificationService implements ChemEquationsTaskEventNotificationService {

    private final KafkaTemplate<String, ChemCompoundEvent> kafkaTemplate;

    @Override
    public void send(ChemCompoundEvent event) {
        ListenableFuture<SendResult<String, ChemCompoundEvent>> future = kafkaTemplate.send("equations-task", UUID.randomUUID().toString(), event);
        future.addCallback(System.out::println, System.out::println);
        kafkaTemplate.flush();
    }
}
