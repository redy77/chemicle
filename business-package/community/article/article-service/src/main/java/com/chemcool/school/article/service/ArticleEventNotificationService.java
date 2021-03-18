package com.chemcool.school.article.service;

import com.chemcool.school.article.domain.ArticleTaskEvent;

/**
 * Event notification service
 *
 * @autor Иван Полещук
 */
public interface ArticleEventNotificationService {
    void send(ArticleTaskEvent event);
}
