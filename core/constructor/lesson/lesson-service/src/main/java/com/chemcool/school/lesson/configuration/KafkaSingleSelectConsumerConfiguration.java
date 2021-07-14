package com.chemcool.school.lesson.configuration;

import com.chemcool.school.lesson.configuration.properties.KafkaProperties;
import com.chemcool.school.lesson.domain.singleselect.ChemSingleSelectTaskEvent;
import com.chemcool.school.lesson.domain.equation.ChemEquationsTaskEvent;
import com.chemcool.school.lesson.domain.matches.ChemMatchingTaskEvent;
import com.chemcool.school.lesson.domain.singleselect.ChemSingleSelectTaskEvent;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableConfigurationProperties(KafkaProperties.class)
@RequiredArgsConstructor
public class KafkaSingleSelectConsumerConfiguration {

    private final KafkaProperties kafkaProperties;

    
    @Bean
    public KafkaListenerContainerFactory chemSingleSelectKafkaListenerContainerFactory() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(JsonDeserializer.VALUE_DEFAULT_TYPE, ChemSingleSelectTaskEvent.class);
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getServer());
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        properties.put(JsonDeserializer.USE_TYPE_INFO_HEADERS, false);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaProperties.getChemSingleSelectGroupId());

        ConcurrentKafkaListenerContainerFactory<String, ChemSingleSelectTaskEvent> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(properties));
        return factory;
    }
}
