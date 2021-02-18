package com.chemcool.school.tasks.chemequations.api.event;

import com.chemcool.school.tasks.chemequations.domain.ChemEquationsTaskEvent;
import com.chemcool.school.tasks.chemequations.service.ChemEquationsTaskEventService;
import com.chemcool.school.tasks.chemequations.service.ChemEquationsTaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@Service
@EnableKafka
@EnableTransactionManagement
@RequiredArgsConstructor
public class ChemEquationsTaskConsumer {

    private final ChemEquationsTaskService taskService;
    private final ChemEquationsTaskEventService eventService;

    @KafkaListener(topics = "equations-task")
    @KafkaHandler
    public void handleChemEquationsTask(ConsumerRecord<String, ChemEquationsTaskEvent> record) {
        ChemEquationsTaskEvent event = record.value();
        log.info("Пойман журнал для логирования с ID: " + event.getEventId());
        eventService.handleEvent(event);
        taskService.save(event.getEventPayload());
    }
}
