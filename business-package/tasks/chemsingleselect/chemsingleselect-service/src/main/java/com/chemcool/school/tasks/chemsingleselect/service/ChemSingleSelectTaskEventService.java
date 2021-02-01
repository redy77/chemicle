package com.chemcool.school.tasks.chemsingleselect.service;

import com.chemcool.school.tasks.chemsingleselect.domain.ChemSingleSelectTask;
import com.chemcool.school.tasks.chemsingleselect.domain.ChemSingleSelectTaskEvent;
import com.chemcool.school.tasks.chemsingleselect.domain.ChemTaskEventType;
import com.chemcool.school.tasks.chemsingleselect.storage.ChemSingleSelectTaskEventJournal;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigInteger;

@Service
@RequiredArgsConstructor
public class ChemSingleSelectTaskEventService {

    private final KafkaTemplate<String, ChemSingleSelectTaskEvent> kafkaTemplate;
    private final ChemSingleSelectTaskEventJournal journal;

    private void kafkaSend(String topic, String msgId, ChemSingleSelectTaskEvent event) {
        ListenableFuture<SendResult<String, ChemSingleSelectTaskEvent>> future = kafkaTemplate.send(topic, msgId, event);
        future.addCallback(System.out::println, System.out::println);
        kafkaTemplate.flush();
    }

    public void save(ChemSingleSelectTask task) {
        //todo написать реализацию
        ChemSingleSelectTaskEvent event = ChemSingleSelectTaskEvent.createEvent(task, ChemTaskEventType.CREATE);
        kafkaSend("ChemSingleSelectTask", "1", event );
        journal.save(event);
    }

    public void update(ChemSingleSelectTask task) {
        //todo написать реализацию
        ChemSingleSelectTaskEvent event = ChemSingleSelectTaskEvent.createEvent(task, ChemTaskEventType.UPDATE);
        kafkaSend("ChemSingleSelectTask", "1", event );
        journal.save(event);
    }

    public void handleEvent(ChemSingleSelectTaskEvent event) {
        journal.save(event);
    }
}
