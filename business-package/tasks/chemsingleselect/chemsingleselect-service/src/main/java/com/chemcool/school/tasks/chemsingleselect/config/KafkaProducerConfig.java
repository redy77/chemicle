package com.chemcool.school.tasks.chemsingleselect.config;

import com.chemcool.school.tasks.chemsingleselect.config.properties.ChemSingleSelectTaskSerializer;
import com.chemcool.school.tasks.chemsingleselect.config.properties.KafkaProperties;
import com.chemcool.school.tasks.chemsingleselect.domain.ChemSingleSelectTaskEvent;
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
public class KafkaProducerConfig {

    private final KafkaProperties kafkaProperties;

    @Bean
    public Map<String, Object> producerConfig() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getServer());
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ChemSingleSelectTaskSerializer.class);
        return properties;
    }

    @Bean
    public ProducerFactory<String, ChemSingleSelectTaskEvent> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    @Bean
    public KafkaTemplate<String, ChemSingleSelectTaskEvent> kafkaTemplate () {
        return new KafkaTemplate<>(producerFactory());
    }
}
