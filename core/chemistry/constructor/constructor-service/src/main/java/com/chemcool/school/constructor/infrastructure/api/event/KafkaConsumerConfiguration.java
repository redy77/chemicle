package com.chemcool.school.constructor.infrastructure.api.event;

import com.chemcool.school.constructor.domain.SingleSelectTask;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Constantine Lee
 * @Date 23.10.2021 5:07
 */
@Configuration
@EnableKafka
public class KafkaConsumerConfiguration {

    @Value(value = "${kafka.server}")
    private String bootstrapserver;
    private final String GROUP_ID = "constructor";

    @Bean
    public ConsumerFactory<String, SingleSelectTask> consumerFactory() {
        JsonDeserializer<SingleSelectTask> deserializer = new JsonDeserializer<>(SingleSelectTask.class);
        deserializer.setRemoveTypeHeaders(false);
        deserializer.addTrustedPackages("*");
        deserializer.setUseTypeMapperForKey(true);

        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapserver);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializer);


        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), deserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, SingleSelectTask> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, SingleSelectTask> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

}
