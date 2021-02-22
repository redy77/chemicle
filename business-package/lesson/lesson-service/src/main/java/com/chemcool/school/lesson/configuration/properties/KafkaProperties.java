package com.chemcool.school.lesson.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("kafka")
public class KafkaProperties {
//    server: http://localhost:9092
//    chemistryLessonGroupId: chemistry-lesson.1
//    chemFixedAnswerGroupId: chemistry-answer.1
//    chemSingleSelectGroupId: chemistry-singleSelect.1
//    theoryGroupId: theory.1

    private String server;
    private String chemistryLessonGroupId;
    private String chemFixedAnswerGroupId;
    private String chemSingleSelectGroupId;
    private String theoryGroupId;
}
