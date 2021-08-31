package com.chemcool.school.theory.configuration;

import com.chemcool.school.theory.configuration.properties.KafkaProperties;
import com.chemcool.school.theory.domain.ChemistryTheoryEvent;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;


@Configuration
@EnableConfigurationProperties(KafkaProperties.class)
@RequiredArgsConstructor
public class KafkaConsumerConfiguration {
    private final KafkaProperties kafkaProperties;

    public static final String TRUSTED_PACKAGES =  "com.chemcool.school.theory.domain";

    @Bean
    public KafkaListenerContainerFactory kafkaListenerContainerFactory() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getServer());
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        properties.put(JsonDeserializer.TRUSTED_PACKAGES, TRUSTED_PACKAGES);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaProperties.getGroupId());

        ConcurrentKafkaListenerContainerFactory<String, ChemistryTheoryEvent> factory=
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(properties));
        return factory;
    }
}
