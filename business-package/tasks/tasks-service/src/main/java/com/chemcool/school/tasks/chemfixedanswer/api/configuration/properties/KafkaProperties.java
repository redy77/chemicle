package com.chemcool.school.tasks.chemfixedanswer.api.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("kafka")

public class KafkaProperties {
    private String server;
    private String groupId;
}
