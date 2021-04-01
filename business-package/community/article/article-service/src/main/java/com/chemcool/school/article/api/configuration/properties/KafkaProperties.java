package com.chemcool.school.article.api.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Kafka параметры
 *
 * @version 1.0
 * @autor Иван Полещук
 */
@Data
@ConfigurationProperties("kafka")
public class KafkaProperties {
    private String server;
    private String groupId;
}
