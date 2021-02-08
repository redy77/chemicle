package com.chemcool.school.theory.service;

import com.chemcool.school.theory.domain.ChemistryTheoryEvent;
import com.chemcool.school.theory.exception.ChemistryTheoryDefenitionException;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class KafkaChemistryTheoryEventNotificationService implements ChemistryTheoryEventNotificationService {

    private final KafkaTemplate<String, ChemistryTheoryEvent> kafkaTemplate;

    private static final String TOPIC = "lesson-theory";

    @Override
    public void send(ChemistryTheoryEvent event) {
        ListenableFuture<SendResult<String, ChemistryTheoryEvent>> future = kafkaTemplate.send(TOPIC, UUID.randomUUID().toString(), event);
        if (future.isCancelled()){
            throw new ChemistryTheoryDefenitionException("Произошла ошибка при записи в кафку");
        }
        kafkaTemplate.flush();
    }

    //    private void kafkaSend(String topic, String msgId, ChemistryTheoryEvent event) {
//        ListenableFuture<SendResult<String, ChemistryTheoryEvent>> future = kafkaTemplate.send(topic, msgId, event);
//        future.addCallback(System.out::println, System.out::println);
//        kafkaTemplate.flush();
//    }
//
//    public void save(ChemistryTheory task) {
//        //todo написать реализацию
//        ChemistryTheoryEvent event = ChemistryTheoryEvent.createEvent(task, ChemistryTheoryEventType.CREATED);
//        kafkaSend("lesson-theory", "1", event);
//    }
//
//    public void update(ChemistryTheory lesson) {
//        //todo написать реализацию
//        ChemistryTheoryEvent event = ChemistryTheoryEvent.createEvent(lesson, ChemistryTheoryEventType.UPDATED);
//        kafkaSend("lesson-theory", "1", event);
//    }
}
