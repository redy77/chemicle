package com.chemcool.school.article.api.event;

import com.chemcool.school.article.domain.ArticleTaskEvent;
import com.chemcool.school.article.service.ArticleEventService;
import com.chemcool.school.article.service.ArticleTaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Consumer for article task
 *
 * @autor Иван Полещук
 */
@Slf4j
@Service
@EnableKafka
@EnableTransactionManagement
@RequiredArgsConstructor
public class ArticleTaskConsumer {

    private final ArticleTaskService taskService;
    private final ArticleEventService eventService;

    @KafkaListener(topics = "article-task")
    @KafkaHandler
    public void handleChemFixedAnswerTask(ConsumerRecord<String, ArticleTaskEvent> record) {
        ArticleTaskEvent event = record.value();
        log.info("Пойман журнал для логирования с ID: " + event.getTaskEventId());
        eventService.handleEvent(event);
        taskService.save(event.getPayload());
    }
}
