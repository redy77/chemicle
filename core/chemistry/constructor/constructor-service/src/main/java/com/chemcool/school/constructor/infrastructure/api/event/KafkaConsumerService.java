package com.chemcool.school.constructor.infrastructure.api.event;

import com.chemcool.school.constructor.domain.SingleSelectTask;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @Author Constantine Lee
 * @Date 23.10.2021 5:09
 */
@Service
@EnableKafka
public class KafkaConsumerService {

    @KafkaListener(topics = "single-select-constructor", groupId = "constructor", containerFactory = "kafkaListenerContainerFactory")

    public void listen(SingleSelectTask task) {
        System.out.println(task);
    }
}
