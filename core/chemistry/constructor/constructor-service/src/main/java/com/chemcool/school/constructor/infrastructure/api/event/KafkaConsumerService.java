package com.chemcool.school.constructor.infrastructure.api.event;

import com.chemcool.school.constructor.domain.Comparison;
import com.chemcool.school.constructor.domain.FixedAnswerTask;
import com.chemcool.school.constructor.domain.SingleSelectTask;
import org.springframework.beans.factory.annotation.Value;
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

public class KafkaConsumerService {

    @Value(value = "${kafka.groupId}")
    private String groupId;

    @KafkaListener(topics = "SINGLE_SELECT", containerFactory = "concurrentKafkaListenerContainerFactory")
    public void listenSingleSelect(@Payload SingleSelectTask task) {
        System.out.println(task);
    }

    @KafkaListener(topics = "COMPARISON", containerFactory = "concurrentKafkaListenerContainerFactory")
    public void listenComparison(@Payload Comparison task) {
        System.out.println(task);
    }

//    @KafkaListener(topics = "FIXED_ANSWER", containerFactory = "concurrentKafkaListenerContainerFactory")
//    public void listenFixedAnswer(@Payload FixedAnswerTask task) {
//        System.out.println(task);
//    }
}
