package com.chemcool.school.tasks.infrastructure.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("kafka")
public class KafkaProperties {
    private String server;
    private String taskCemEquationsGroupId;
    private String taskChemFixedAnswerGroupId;
    private String taskChemMatchesGroupId;
    private String taskChemSingleSelectGroupId;
}
