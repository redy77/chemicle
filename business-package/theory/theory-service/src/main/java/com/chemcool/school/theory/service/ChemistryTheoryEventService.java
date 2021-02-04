package com.chemcool.school.theory.service;


import com.chemcool.school.theory.domain.ChemistryTheory;
import com.chemcool.school.theory.domain.ChemistryTheoryEvent;
import com.chemcool.school.theory.domain.ChemistryTheoryEventType;
import com.chemcool.school.theory.storage.ChemistryTheoryEventJournal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChemistryTheoryEventService {

    private final KafkaTemplate<String, ChemistryTheoryEvent> kafkaTemplate;
    private final ChemistryTheoryEventJournal journal;

    private void kafkaSend(String topic, String msgId, ChemistryTheoryEvent event) {
        ListenableFuture<SendResult<String, ChemistryTheoryEvent>> future = kafkaTemplate.send(topic, msgId, event);
        future.addCallback(System.out::println, System.out::println);
        kafkaTemplate.flush();
    }

    public void save(ChemistryTheory task) {
        //todo написать реализацию
        ChemistryTheoryEvent event = ChemistryTheoryEvent.createEvent(task, ChemistryTheoryEventType.CREATED);
        kafkaSend("lesson-theory", "1", event);
    }

    public void update(ChemistryTheory lesson) {
        //todo написать реализацию
        ChemistryTheoryEvent event = ChemistryTheoryEvent.createEvent(lesson, ChemistryTheoryEventType.UPDATED);
        kafkaSend("lesson-theory", "1", event);
    }
}
