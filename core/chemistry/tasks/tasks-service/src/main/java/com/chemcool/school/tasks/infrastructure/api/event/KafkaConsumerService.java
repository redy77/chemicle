package com.chemcool.school.tasks.infrastructure.api.event;

import com.chemcool.school.tasks.models.Task;
import com.chemcool.school.tasks.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
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

    private final TaskService taskService;

    @KafkaListener(topics = "tasks", groupId = "groupId", containerFactory = "concurrentKafkaListenerContainerFactory")
    public void listenTask(@Payload Task task) {
        log.info("Task with id {} was received.", task.getTaskId());
        taskService.save(task);
    }
}
