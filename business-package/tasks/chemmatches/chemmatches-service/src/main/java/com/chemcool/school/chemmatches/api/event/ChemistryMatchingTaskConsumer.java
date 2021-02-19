package com.chemcool.school.chemmatches.api.event;

import com.chemcool.school.chemmatches.domain.ChemistryMatchingTaskEvent;
import com.chemcool.school.chemmatches.service.ChemistryMatchingTaskEventService;
import com.chemcool.school.chemmatches.service.ChemistryMatchingTaskService;
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
public class ChemistryMatchingTaskConsumer {

    private final ChemistryMatchingTaskEventService eventService;
    private final ChemistryMatchingTaskService taskService;

    @KafkaListener(topics = "tasks-matching")
    @KafkaHandler
    public void handleChemSingleSelectTask(ConsumerRecord<String, ChemistryMatchingTaskEvent> record) {
        ChemistryMatchingTaskEvent event = record.value();
        log.info("Пойман журнал для логирования: " + event.getChemistryMatchingTaskEventId());
        eventService.handleEvent(event);
        taskService.handleTask(event.getChemistryMatchingTaskEventPayload());
    }
}
