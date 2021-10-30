package com.chemcool.school.tasks.infrastructure.configuration;

import com.chemcool.school.tasks.domain.AbstractTask;
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

@Configuration
@EnableKafka
public class KafkaConsumerConfiguration {

    @Value(value = "${kafka.server}")
    private String bootstrapserver;

    @Value(value = "${kafka.groupId}")
    private String groupId;

    @Value(value = "${spring.kafka.consumer.properties.spring.json.type.mapping}")
    private String typeMappings;

    @Bean
    public ConsumerFactory<String, AbstractTask> consumerFactory() {

        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapserver);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        config.put(JsonDeserializer.TYPE_MAPPINGS, typeMappings);

        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), null);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, AbstractTask> concurrentKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, AbstractTask> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
