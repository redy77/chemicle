package com.chemcool.school.constructor.service.kafka;


import com.chemcool.school.tasks.models.Task;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.UUID;

@Service
@AllArgsConstructor
public class KafkaTaskEventNotificationService<T extends Task> implements TaskEventNotificationService<T> {

    private final KafkaTemplate<String, T> kafkaTemplate;

    @Override
    public void send(T event, String kafkaTopicName) {
        ListenableFuture<SendResult<String, T>> future = kafkaTemplate
                .send(
                        kafkaTopicName,
                        UUID.randomUUID().toString(),
                        event);
        //TODO настроить callback
        future.addCallback(System.out::println, System.out::println);
        kafkaTemplate.flush();
    }
}
