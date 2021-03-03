package com.chemcool.school.config;

import com.chemcool.school.dto.GotFromFrontEnd;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Deserializer;

import java.nio.charset.StandardCharsets;
import java.util.Map;


    @Slf4j
    public class GotFromFrontDeserializer implements Deserializer<GotFromFrontEnd> {
        private final ObjectMapper mapper = new ObjectMapper()
                .registerModule(new JavaTimeModule());


        @Override
        public void configure(Map<String,?> map, boolean b){

        }

        @Override
        public GotFromFrontEnd deserialize(String s, byte[] event){
            try {
                return mapper.readValue(new String(event, StandardCharsets.UTF_8), GotFromFrontEnd.class);
            }catch (Exception exception){
                log.error("Unable to deserialize message {}" ,event, exception);
                return null;
            }
        }
        @Override
        public void close(){

        }

    }
