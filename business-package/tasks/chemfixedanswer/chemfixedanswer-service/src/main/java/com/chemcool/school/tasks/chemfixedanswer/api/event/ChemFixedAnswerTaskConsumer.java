package com.chemcool.school.tasks.chemfixedanswer.api.event;

import com.chemcool.school.tasks.chemfixedanswer.domain.ChemFixedAnswerTaskEvent;
import com.chemcool.school.tasks.chemfixedanswer.service.ChemFixedAnswerTaskEventNotificationService;
import com.chemcool.school.tasks.chemfixedanswer.service.ChemFixedAnswerTaskEventService;
import com.chemcool.school.tasks.chemfixedanswer.service.ChemFixedAnswerTaskService;
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
public class ChemFixedAnswerTaskConsumer {

    private final ChemFixedAnswerTaskService taskService;
    private final ChemFixedAnswerTaskEventService eventService;
    private final ChemFixedAnswerTaskEventNotificationService notificationService;

    @KafkaListener(topics = "fixed-answer-task")
    @KafkaHandler
    public void handleChemFixedAnswerTask(ConsumerRecord<String, ChemFixedAnswerTaskEvent> record) {
        ChemFixedAnswerTaskEvent event = record.value();
        log.info("Пойман журнал для логирования " + event.getEventId());
        notificationService.send(event);
        eventService.handleEvent(event);
        taskService.update(event.getEventPayload());
    }
}
