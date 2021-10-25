package com.chemcool.school.tasks.infrastructure.api.event;

import com.chemcool.school.tasks.domain.Comparison;
import com.chemcool.school.tasks.domain.FixedAnswerTask;
import com.chemcool.school.tasks.domain.SingleSelectTask;
import com.chemcool.school.tasks.service.ComparisonService;
import com.chemcool.school.tasks.service.FixedAnswerService;
import com.chemcool.school.tasks.service.SingleSelectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * @Author Constantine Lee
 * @Date 23.10.2021
 */
@Service
@EnableKafka
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumerService {

    private final ComparisonService comparisonService;
    private final SingleSelectService singleSelectService;
    private final FixedAnswerService fixedAnswerService;

    @KafkaListener(topics = "SINGLE_SELECT", containerFactory = "concurrentKafkaListenerContainerFactory")
    public void listenSingleSelect(@Payload SingleSelectTask task) {
        log.info("Task was received from topic: " + task.getTaskType());
        singleSelectService.save(task);
    }

    @KafkaListener(topics = "COMPARISON", containerFactory = "concurrentKafkaListenerContainerFactory")
    public void listenComparison(@Payload Comparison task) {
        log.info("Task was received from topic: " + task.getTaskType());
        comparisonService.save(task);
    }

    @KafkaListener(topics = "FIXED_ANSWER", containerFactory = "concurrentKafkaListenerContainerFactory")
    public void listenFixedAnswer(@Payload FixedAnswerTask task) {
        log.info("Task was received from topic: " + task.getTaskType());
        fixedAnswerService.save(task);
    }
}
