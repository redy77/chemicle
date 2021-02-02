package com.chemcool.school.tasks.chemsingleselect.api.event;

import com.chemcool.school.tasks.chemsingleselect.domain.ChemSingleSelectTask;
import com.chemcool.school.tasks.chemsingleselect.domain.ChemSingleSelectTaskEvent;
import com.chemcool.school.tasks.chemsingleselect.domain.ChemTaskEventType;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;


@Service
@RequiredArgsConstructor
public class ChemSingleSelectTaskEventProducer {

    private final KafkaTemplate<String, ChemSingleSelectTaskEvent> kafkaTemplate;

    private void kafkaSend(String topic, String msgId, ChemSingleSelectTaskEvent event) {
        ListenableFuture<SendResult<String, ChemSingleSelectTaskEvent>> future = kafkaTemplate.send(topic, msgId, event);
        future.addCallback(System.out::println, System.out::println);
        kafkaTemplate.flush();
    }

    public void save(ChemSingleSelectTask task) {
        //todo написать реализацию
        ChemSingleSelectTaskEvent event = ChemSingleSelectTaskEvent.createEvent(task, ChemTaskEventType.CREATE);
        kafkaSend("single-select-task", "1", event );
    }

    public void update(ChemSingleSelectTask task) {
        //todo написать реализацию
        ChemSingleSelectTaskEvent event = ChemSingleSelectTaskEvent.createEvent(task, ChemTaskEventType.UPDATE);
        kafkaSend("single-select-task", "1", event );
    }


}
