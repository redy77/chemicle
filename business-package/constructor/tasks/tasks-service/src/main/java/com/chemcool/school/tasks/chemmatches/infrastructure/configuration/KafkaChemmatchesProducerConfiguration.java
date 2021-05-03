package com.chemcool.school.tasks.chemmatches.infrastructure.configuration;

import com.chemcool.school.tasks.chemmatches.infrastructure.configuration.properties.ChemistryMatchingTaskSerializer;
import com.chemcool.school.tasks.chemmatches.infrastructure.configuration.properties.KafkaProperties;
import com.chemcool.school.tasks.chemmatches.domain.ChemistryMatchingTaskEvent;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableConfigurationProperties(KafkaProperties.class)
@RequiredArgsConstructor
public class KafkaChemmatchesProducerConfiguration {

    private final KafkaProperties kafkaProperties;

    public Map<String, Object> producerConfig() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getServer());
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ChemistryMatchingTaskSerializer.class);
        return properties;
    }

    @Bean
    public ProducerFactory<String, ChemistryMatchingTaskEvent> chemistryMatchingTaskEventProducerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    @Bean
    public KafkaTemplate<String, ChemistryMatchingTaskEvent> chemistryMatchingTaskEventKafkaTemplate() {
        return new KafkaTemplate<>(chemistryMatchingTaskEventProducerFactory());
    }
}
