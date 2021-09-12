package com.chemcool.school.tasks.infrastructure.api.event;

import com.chemcool.school.tasks.infrastructure.configuration.kafka.ModelServiceExecutor;
import com.chemcool.school.tasks.models.Task;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Service
@EnableKafka
@EnableTransactionManagement
@RequiredArgsConstructor
public class KafkaTaskConsumer {

    private final ModelServiceExecutor modelServiceExecutor;

    @KafkaListener(topics = "#{kafkaTopics}", containerFactory = "kafkaTaskListenerContainerFactory")
    @KafkaHandler
    public void taskListener(ConsumerRecord<String, Task> record) {
        Task event = record.value();
        modelServiceExecutor.execute(event);
    }
}
