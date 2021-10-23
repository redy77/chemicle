package com.chemcool.school.constructor.infrastructure.api.event;

import com.chemcool.school.constructor.domain.SingleSelectTask;
import com.chemcool.school.tasks.models.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author Constantine Lee
 * @Date 23.10.2021 4:12
 */
@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, SingleSelectTask> kafkaTemplate;

    public void sendTask(String topic, SingleSelectTask task) {
        kafkaTemplate.send(topic, task);
    }
}
