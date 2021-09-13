package com.chemcool.school.tasks.infrastructure.configuration.kafka;

import com.chemcool.school.tasks.statuses.TaskType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Scope("singleton")
public class KafkaTopicsList {

    @Bean(name = "kafkaTopics")
    public String[] kafkaTopics() {
        return Arrays.toString(TaskType.values())
                .replaceAll("^.|.$", "")
                .split(", ");
    }
}
