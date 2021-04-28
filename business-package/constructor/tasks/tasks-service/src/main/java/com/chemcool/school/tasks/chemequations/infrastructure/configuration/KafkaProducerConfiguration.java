package com.chemcool.school.tasks.chemequations.infrastructure.configuration;

import com.chemcool.school.tasks.chemequations.infrastructure.configuration.properties.ChemEquationsTaskSerialize;
import com.chemcool.school.tasks.chemequations.infrastructure.configuration.properties.KafkaProperties;
import com.chemcool.school.tasks.chemequations.domain.ChemEquationsTaskEvent;
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

/**
 * Configuration Kafka Producer
 *
 * @version 1.0
 * @autor Евгений Жиленков
 */
@Configuration
@EnableConfigurationProperties(KafkaProperties.class)
@RequiredArgsConstructor
public class KafkaProducerConfiguration {

    private final KafkaProperties kafkaProperties;

    @Bean
    public Map<String, Object> producerConfig(){
        Map<String, Object> prop = new HashMap<>();
        prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getServer());
        prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ChemEquationsTaskSerialize.class);
        return prop;
    }

    @Bean
    public ProducerFactory<String, ChemEquationsTaskEvent> producerFactory(){
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    @Bean
    public KafkaTemplate<String, ChemEquationsTaskEvent> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }
}
