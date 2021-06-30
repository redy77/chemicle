package com.chemcool.school.auth.service.config;

import com.chemcool.school.auth.service.config.properties.KafkaProperties;
import com.chemcool.school.auth.service.domain.RegisterUserEvent;
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
@RequiredArgsConstructor
@EnableConfigurationProperties(KafkaProperties.class)
public class KafkaConsumerConfiguration {

    private final String TRUSTED_PACKAGES = "com.chemcool.school.registration.domain";

    private final KafkaProperties kafkaProperties;

    
    @Bean
    public KafkaListenerContainerFactory<?> kafkaListenerContainerFactory() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getServer());
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        properties.put(JsonDeserializer.TRUSTED_PACKAGES, TRUSTED_PACKAGES);
        properties.put(JsonDeserializer.VALUE_DEFAULT_TYPE, RegisterUserEvent.class);
        properties.put(JsonDeserializer.USE_TYPE_INFO_HEADERS, false);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaProperties.getGroupId());

        ConcurrentKafkaListenerContainerFactory<String, RegisterUserEvent> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(properties));
        return factory;
    }
}