package com.chemcool.school.tasks.infrastructure.configuration;

import com.chemcool.school.tasks.infrastructure.configuration.properties.KafkaProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.KafkaListenerContainerFactory;


@Configuration
@EnableConfigurationProperties(KafkaProperties.class)
@RequiredArgsConstructor
public class KafkaConsumerConfiguration {

    private final KafkaProperties kafkaProperties;


    @Bean
    public KafkaListenerContainerFactory taskKafkaListenerContainerFactory() {
//        Map<String, Object> properties = new HashMap<>();
//        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,kafkaProperties.getServer());
//        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
//        properties.put(JsonDeserializer.VALUE_DEFAULT_TYPE, ChemTheoryEvent.class);
//        properties.put(JsonDeserializer.USE_TYPE_INFO_HEADERS, false);
//        properties.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaProperties.getTheoryGroupId());

// FIXME: перенес класс из lesson для единообразия и для устранения ошибки в классе KafkaProperties.java
//
//        ConcurrentKafkaListenerContainerFactory<String, ChemTheoryEvent> factory=
//                new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(properties));
        return null; //FIXME: прежде было: return factory;
    }
}
