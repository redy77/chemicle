package com.chemcool.school.article.service;

import com.chemcool.school.article.domain.ArticleTaskEvent;
import com.chemcool.school.article.storage.ArticleTaskEventJournal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Event service
 *
 * @autor Иван Полещук
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ArticleEventService {
    private final ArticleTaskEventJournal eventJournal;

    public void handleEvent(ArticleTaskEvent event) {
        eventJournal.save(event);
        log.info("Событие отправлено на сохранение");
    }
}
