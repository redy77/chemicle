package com.chemcool.school.tasks.infrastructure.configuration.properties.consumers;

import com.chemcool.school.tasks.domain.chemfixedanswer.ChemFixedAnswerTaskEvent;
import com.chemcool.school.tasks.infrastructure.configuration.properties.KafkaJsonDeserializer;
import com.chemcool.school.tasks.infrastructure.configuration.kafka.KafkaProperties;
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
public class KafkaChemFixedAnswerConsumerConfiguration {

    private final String TRUSTED_PACKAGES = "com.chemcool.school.tasks.domain.chemfixedanswer";

    private final KafkaProperties kafkaProperties;

    public Map<String, Object> consumerConfig(){
        //TODO этот класс надо удалить?
        Map<String, Object> prop = new HashMap<>();
        prop.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getServer());
        prop.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        prop.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaJsonDeserializer.class);
        prop.put(JsonDeserializer.TRUSTED_PACKAGES, TRUSTED_PACKAGES);
        prop.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaProperties.getGroupId());
        return prop;
    }

    @Bean
    public KafkaListenerContainerFactory kafkaChemFixedAnswerListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, ChemFixedAnswerTaskEvent> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

    public ConsumerFactory<String, ChemFixedAnswerTaskEvent> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfig(), new StringDeserializer(),
                new KafkaJsonDeserializer<ChemFixedAnswerTaskEvent>(ChemFixedAnswerTaskEvent.class));
    }
}
