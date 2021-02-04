package com.chemcool.school.tasks.chemsingleselect.config.properties;

import com.chemcool.school.tasks.chemsingleselect.domain.ChemSingleSelectTaskEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

@Slf4j
public class ChemSingleSelectTaskSerializer implements Serializer<ChemSingleSelectTaskEvent> {

    private final ObjectMapper mapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());

    @Override
    public void configure(Map<String, ?> map, boolean isKey) {
    }

    @Override
    public byte[] serialize(String topic, ChemSingleSelectTaskEvent event) {
        try {
            return mapper.writeValueAsBytes(event);
        } catch (JsonProcessingException exception) {
            log.error("Неудалось сереализовать объект", event, exception);
            return null;
        }
    }

    @Override
    public void close() {
    }
}
