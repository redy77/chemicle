package com.chemcool.school.article.service;

import com.chemcool.school.article.domain.ArticleTaskEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.UUID;

/**
 * Реализация уведомления о событии с соединениями
 *
 * @version 1.0
 * @autor Иван Полещук
 */
@Slf4j
@Service
@AllArgsConstructor
public class KafkaArticleNotificationService implements ArticleEventNotificationService {

    private final KafkaTemplate<String, ArticleTaskEvent> kafkaTemplate;

    @Override
    public void send(ArticleTaskEvent event) {
        ListenableFuture<SendResult<String, ArticleTaskEvent>> future = kafkaTemplate.send("article-task", UUID.randomUUID().toString(), event);
        future.addCallback(System.out::println, System.out::println);
        kafkaTemplate.flush();
    }
}
