package com.chemcool.school.lesson.configuration.properties;

import com.chemcool.school.lesson.domain.ChemistryLessonEvent;
import com.chemcool.school.lesson.tasks.chemsingleselect.domain.ChemSingleSelectTaskEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Deserializer;

import java.nio.charset.StandardCharsets;
import java.util.Map;

@Slf4j
public class ChemLessonDeserializer implements Deserializer<ChemistryLessonEvent> {
    private final ObjectMapper mapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public ChemistryLessonEvent deserialize(String topic, byte[] event) {
        try {
            return mapper.readValue(new String(event, StandardCharsets.UTF_8), ChemistryLessonEvent.class);
        } catch (Exception exception) {
            log.error("Невозможно десериализовать сообщение {}", event, exception);
            return null;
        }
    }

    @Override
    public void close() {
    }
}
