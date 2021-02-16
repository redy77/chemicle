package com.chemcool.school.registration.api.event;

import com.chemcool.school.registration.domain.RegisterUserEvent;
import com.chemcool.school.registration.service.RegisterUserEventService;
import com.chemcool.school.registration.service.RegisterUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@Service
@EnableKafka
@EnableTransactionManagement
@RequiredArgsConstructor
public class RegisterUserConsumer {
    private final RegisterUserEventService registerUserEventService;
    private final RegisterUserService registerUserService;

    @KafkaListener(topics = "user-registration")
    @KafkaHandler
    public void orderListener(ConsumerRecord<String, RegisterUserEvent> record) {
        RegisterUserEvent event = record.value();
        log.info("Пойман журнал для логирования: {}", event.getEventId());
        log.info("Ник нового юзера: {}", event.getPayload().getNick());
        registerUserEventService.saveEvent(event);
        registerUserService.save(event.getPayload());
    }
}
