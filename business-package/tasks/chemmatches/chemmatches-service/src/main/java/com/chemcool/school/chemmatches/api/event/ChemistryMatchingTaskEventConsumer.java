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
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@EnableKafka
@RequiredArgsConstructor
@EnableTransactionManagement
public class ChemistryMatchingTaskEventConsumer {

    private final ChemistryMatchingTaskEventService eventService;

    @KafkaHandler
    @KafkaListener(topics = "matching-task")
    @Transactional
    public void handleChemistryMatchingTask(ConsumerRecord<String, ChemistryMatchingTaskEvent> record) {
        ChemistryMatchingTaskEvent event = record.value();
        log.info("Пойман журнал для логирования: " + event.getChemistryMatchingTaskEventId());
        eventService.handleEvent(event);
    }
}
