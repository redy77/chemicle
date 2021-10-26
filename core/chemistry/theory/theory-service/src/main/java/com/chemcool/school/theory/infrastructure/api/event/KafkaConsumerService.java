package com.chemcool.school.theory.infrastructure.api.event;

import com.chemcool.school.theory.domain.TheoryTask;
import com.chemcool.school.theory.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * @Author : Constantine Lee
 * @Date : 26.10.2021
 * @e-mail : rhowbn@gmail.com
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumerService {

    private final TaskService taskService;

    @KafkaListener(topics = "theory", containerFactory = "concurrentKafkaListenerContainerFactory")
    public void listenTheory(@Payload TheoryTask task) {
        log.info("Task with id {} was received.", task.getTaskId());
        taskService.save(task);
    }
}
