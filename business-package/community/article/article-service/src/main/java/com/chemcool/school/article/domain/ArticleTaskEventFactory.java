package com.chemcool.school.article.domain;

import com.chemcool.school.article.exception.ArticleEventException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Event factory for articles
 *
 * @autor Иван Полещук
 */
@Slf4j
@Component
public class ArticleTaskEventFactory {
    public static ArticleTaskEvent createTaskEvent(ArticlesTask task, ArticleEventType eventType) {
        if (false) {
            //ToDO: реализовать логику для фабрики события создания таски
            throw new ArticleEventException("Что-то не получилось для создания ивента");
        }
        log.info("Попытка создать событие {} при создании статьи ", eventType);
        return ArticleTaskEvent.createEvent(task, UUID.randomUUID().toString(), eventType);
    }
}
