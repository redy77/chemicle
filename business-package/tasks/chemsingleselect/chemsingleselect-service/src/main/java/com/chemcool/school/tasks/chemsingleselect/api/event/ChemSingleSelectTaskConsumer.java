package com.chemcool.school.tasks.chemsingleselect.api.event;

import com.chemcool.school.tasks.chemsingleselect.domain.ChemSingleSelectTaskEvent;
import com.chemcool.school.tasks.chemsingleselect.service.ChemSingleSelectTaskEventService;
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
public class ChemSingleSelectTaskConsumer {

    private final ChemSingleSelectTaskEventService eventService;

    @KafkaListener(topics = "single-select-task")
    @KafkaHandler
    public void handleChemSingleSelectTask(ConsumerRecord<String, ChemSingleSelectTaskEvent> record) {
        ChemSingleSelectTaskEvent event = record.value();
        log.info("Пойман журнал для логирования: " + event.getTaskEventId());
        eventService.handleEvent(event);
    }

}
