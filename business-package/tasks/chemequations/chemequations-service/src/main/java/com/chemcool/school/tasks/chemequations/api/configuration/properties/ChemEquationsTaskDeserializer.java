package com.chemcool.school.tasks.chemequations.api.configuration.properties;

import com.chemcool.school.tasks.chemequations.domain.ChemCompoundEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Deserializer;

import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * Десериализатор событий для Kafka
 *
 * @version 1.0
 * @autor Евгений Жиленков
 */
@Slf4j
public class ChemEquationsTaskDeserializer implements Deserializer<ChemCompoundEvent> {

    private final ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @Override
    public void configure(Map<String, ?> map, boolean b) {
    }

    @Override
    public ChemCompoundEvent deserialize(String s, byte[] event) {
        try {
            return mapper.readValue(new String(event, StandardCharsets.UTF_8), ChemCompoundEvent.class);
        } catch (Exception exception) {
            log.error("Unable to deserialize message {}", event, exception);
            return null;
        }
    }

    @Override
    public void close() {
    }
}
