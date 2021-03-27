package com.chemcool.school.article.service;

import com.chemcool.school.article.domain.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The third layer for work db operations
 *
 * @autor Иван Полещук
 */
@Slf4j
@Service
@AllArgsConstructor
public class ArticleProxyService {

    private final ArticleEventNotificationService notificationService;
    private final ArticleTaskService taskService;

    public List<ArticlesTask> getAll() {
        return taskService.getAll();
    }

    public Optional<ArticlesTask> getById(String id) {
        return taskService.getById(id);
    }

    public String add(ArticlesTaskExample exampleTask) {
        ArticlesTask task = ArticleTaskFactory.createArticlesTask(exampleTask);
        notificationService.send(ArticleTaskEventFactory.createTaskEvent(task, ArticleEventType.CREATE));
        log.info("Статья с ID " + task.getArticleId() + " передана на добавление");
        return task.getArticleId();
    }

    public void update(ArticlesTask exampleTask) {
        taskService.update(exampleTask);
        notificationService.send(
                ArticleTaskEventFactory.createTaskEvent(exampleTask, ArticleEventType.UPDATE)
        );
        log.info("Статья с ID " + exampleTask.getArticleId() + " передана на обновление");
    }

    public void delete(String id) {
        taskService.delete(id);
        log.info("Статья с ID " + id + " передана на удаление");
    }
}
