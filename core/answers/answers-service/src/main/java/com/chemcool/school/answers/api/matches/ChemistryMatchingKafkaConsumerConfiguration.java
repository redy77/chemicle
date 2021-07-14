package com.chemcool.school.answers.api.matches;

import com.chemcool.school.answers.api.KafkaProperties;
import com.chemcool.school.answers.domain.matches.ChemistryMatchingTaskEvent;
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
public class ChemistryMatchingKafkaConsumerConfiguration {

    private final KafkaProperties kafkaProperties;


    @Bean
    public KafkaListenerContainerFactory matchingKafkaListenerContainerFactory() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getServer());
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        properties.put(JsonDeserializer.VALUE_DEFAULT_TYPE, ChemistryMatchingTaskEvent.class);
        properties.put(JsonDeserializer.USE_TYPE_INFO_HEADERS, false);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaProperties.getGroupId2());

        ConcurrentKafkaListenerContainerFactory<String, ChemistryMatchingTaskEvent> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(properties));
        return factory;
    }
}
