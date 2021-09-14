package com.chemcool.school.constructor.service.kafka;

public interface TaskEventNotificationService<T> {
    public void send(T event, String kafkaTopicName);
}
