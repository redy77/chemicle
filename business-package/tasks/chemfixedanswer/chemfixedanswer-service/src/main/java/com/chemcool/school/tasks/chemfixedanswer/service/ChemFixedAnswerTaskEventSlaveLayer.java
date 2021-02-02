package com.chemcool.school.tasks.chemfixedanswer.service;

import com.chemcool.school.tasks.chemfixedanswer.domain.ChemFixedAnswerTask;
import com.chemcool.school.tasks.chemfixedanswer.domain.ChemFixedAnswerTaskEvent;
import com.chemcool.school.tasks.chemfixedanswer.domain.ChemFixedAnswerTaskEventType;
import com.chemcool.school.tasks.chemfixedanswer.storage.ChemFixedAnswerTaskEventJournal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChemFixedAnswerTaskEventSlaveLayer {

    private final ChemFixedAnswerTaskEventJournal journal;
    private final KafkaTemplate<String, ChemFixedAnswerTaskEventService> kafkaTemplate;

    private void kafkaSend(String topic, String msgId, ChemFixedAnswerTaskEvent event){
        ListenableFuture<SendResult<String, ChemFixedAnswerTaskEvent>> future = kafkaTemplate.send(topic, msgId, event);
        future.addCallback(System.out::println, System.out::println);
        kafkaTemplate.flush();
    }

    public void save(ChemFixedAnswerTask task) {
        ChemFixedAnswerTaskEvent event = ChemFixedAnswerTaskEvent.createEvent(task, ChemFixedAnswerTaskEventType.CREATE);
        kafkaSend("ChemFixedAnswerTask", "1", event);
        journal.save(event);
        log.info("Cоздано и сохранено событие с ID " + event.getChemFixedAnswerTaskEventId());

    }

    public void update(ChemFixedAnswerTask task) {
        ChemFixedAnswerTaskEvent event = ChemFixedAnswerTaskEvent.createEvent(task, ChemFixedAnswerTaskEventType.UPDATE);
        kafkaSend("ChemFixedAnswerTask", "1", event);
        journal.save(event);
    }
}
