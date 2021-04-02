package com.chemcool.school.article.api.configuration.properties;

import com.chemcool.school.article.domain.ArticleTaskEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

/**
 * Сериализатор событий для Kafka
 *
 * @version 1.0
 * @autor Иван Полещук
 */
@Slf4j
public class ArticleTaskSerialize implements Serializer<ArticleTaskEvent> {

    private final ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public byte[] serialize(String s, ArticleTaskEvent event) {
        try {
            return mapper.writeValueAsBytes(event);
        } catch (JsonProcessingException exception) {
            log.error("Unable to serialize object {}", event, exception);
            return null;
        }
    }

    @Override
    public void close() {
    }
}
