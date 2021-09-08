package com.chemcool.school.constructor.infrastructure.configuration.kafka;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("kafka")
public class KafkaProperties {
    private String server;
    private String constructorComparisonGroupId;
    private String constructorFixedAnswerGroupId;
    private String constructorMatchesGroupId;
    private String constructorSingleSelectGroupId;
}
