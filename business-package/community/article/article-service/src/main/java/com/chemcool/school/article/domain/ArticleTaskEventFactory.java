package com.chemcool.school.article.domain;

import com.chemcool.school.article.exception.ArticleEventException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Event factory for articles
 *
 * @autor Иван Полещук
 */
@Slf4j
@Component
public class ArticleTaskEventFactory {
    public static ArticleTaskEvent createTaskEvent(ArticlesTask task, ArticleEventType eventType) {
        try {
            log.info("Попытка создать событие {} при создании статьи ", eventType);
            return ArticleTaskEvent.createEvent(task, eventType);
        } catch (Throwable th) {
            throw new ArticleEventException("Что-то не получилось для создания ивента");
        }
    }
}
