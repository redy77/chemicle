package com.chemcool.school.lesson.tasks.chemmatches.service;

import com.chemcool.school.lesson.tasks.chemmatches.domain.ChemistryMatchingTaskEvent;
import com.chemcool.school.lesson.tasks.chemmatches.exception.ChemistryMatchingTaskException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.UUID;


@Slf4j
@Service
@AllArgsConstructor
public class KafkaChemistryMatchingTaskEventNotificationService implements ChemistryMatchingTaskEventNotificationService {

    private final KafkaTemplate<String, ChemistryMatchingTaskEvent> kafkaTemplate;
    private static final String TOPIC = "tasks-matching";

    @Override
    public void send(ChemistryMatchingTaskEvent event) {
        ListenableFuture<SendResult<String, ChemistryMatchingTaskEvent>> future = kafkaTemplate.send(TOPIC, UUID.randomUUID().toString(), event);
        if (future.isCancelled()) {
            throw new ChemistryMatchingTaskException("Произошла ошибка при записи в кафку");
        }
        kafkaTemplate.flush();
    }
}
/*
  private final KafkaTemplate<String, ChemFixedAnswerTaskEvent> kafkaTemplate;

    @Override
    public void send(ChemFixedAnswerTaskEvent event) {
        ListenableFuture<SendResult<String, ChemFixedAnswerTaskEvent>> future = kafkaTemplate.send("fixed-answer-task", UUID.randomUUID().toString(), event);
        future.addCallback(System.out::println, System.out::println);
        kafkaTemplate.flush();
    }
 */