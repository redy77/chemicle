package com.chemcool.school.constructor.service.kafka;

import com.chemcool.school.tasks.models.Task;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaCommonProducer {

    private final TaskEventNotificationService<Task> kafkaTaskEventNotificationService;

    public void send(Task task, String topicName) {
        kafkaTaskEventNotificationService.send(task, topicName);
    }
}
