package com.chemcool.school.constructor.service;

import com.chemcool.school.constructor.domain.FixedAnswerTask;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FixedProducerService {

    KafkaTemplate<String, FixedAnswerTask> kafkaTemplate;

    public void producer(FixedAnswerTask fixedAnswerTask) {
        kafkaTemplate.send("fixedTasks",fixedAnswerTask);
    }
}
