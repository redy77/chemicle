package com.chemcool.school.constructor.infrastructure.api.event;

import com.chemcool.school.tasks.models.Task;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @Author Constantine Lee
 * @Date 23.10.2021
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducerService {

//    private final String TOPIC = "tasks";
    private final KafkaTemplate<String, Task> kafkaTemplate;


    public void sendToKafka(String topic, Task task) {
        ListenableFuture<SendResult<String, Task>> future = kafkaTemplate.send(topic, task);
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.error("Unable to send message: " + throwable);
            }

            @Override
            public void onSuccess(SendResult<String, Task> sendResult) {
                log.info("Message was sent to topic: " + sendResult.getRecordMetadata().topic() +
                        ", with offset: " + sendResult.getRecordMetadata().offset() +
                        ", at: " + sendResult.getRecordMetadata().timestamp());
            }
        });
    }
}
