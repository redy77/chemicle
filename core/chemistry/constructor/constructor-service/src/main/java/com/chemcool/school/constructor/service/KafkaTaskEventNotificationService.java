package com.chemcool.school.constructor.service;

import com.chemcool.school.tasks.models.Task;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class KafkaTaskEventNotificationService<T extends Task> {

    private final KafkaTemplate<String, T> kafkaTemplate;

    public void send(T event, String kafkaTopicName) {
        ListenableFuture<SendResult<String, T>> future = kafkaTemplate
                .send(
                        kafkaTopicName,
                        UUID.randomUUID().toString(),
                        event);
        future.addCallback(System.out::println, System.out::println);
        kafkaTemplate.flush();
    }
}
