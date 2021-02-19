package com.chemcool.school.registration.service;

import com.chemcool.school.registration.domain.RegisterUserEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegisterUserEventNotificationServiceImpl implements RegisterUserEventNotificationService {

    private final KafkaTemplate<String, RegisterUserEvent> kafkaTemplate;
    private static final String TOPIC = "user-registration";

    @Override
    public void send(RegisterUserEvent event) {
        ListenableFuture<SendResult<String, RegisterUserEvent>> future = kafkaTemplate.send(TOPIC,
                UUID.randomUUID().toString(), event);

        if (future.isCancelled()) {
            throw new RuntimeException("Произошла ошибка при записи в кафку");
        }
        kafkaTemplate.flush();
    }
}
