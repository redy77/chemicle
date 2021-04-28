package com.chemcool.school.tasks.chemequations.infrastructure.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Kafka параметры
 *
 * @version 1.0
 * @autor Евгений Жиленков
 */
@Data
@ConfigurationProperties("kafka")
public class KafkaProperties {
    private String server;
    private String groupId;
}
