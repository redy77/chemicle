package com.chemcool.school.article.service;

import com.chemcool.school.article.domain.ArticlesTask;
import com.chemcool.school.article.storage.ArticleTaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The fourth layer for work db operations
 *
 * @version 1.0
 * @autor Иван Полещук
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ArticleTaskService {

    private final ArticleTaskRepository repository;

    public List<ArticlesTask> getAll() {
        return repository.findAll();
    }

    public Optional<ArticlesTask> getById(String id) {
        return repository.findById(id);
    }

    public void save(ArticlesTask task) {
        repository.save(task);
        log.info("Статья с ID: " + task.getArticleId() + " сохранена.");
    }

    public void update(ArticlesTask task) {
        repository.save(task);
        log.info("Обновлена задача с ID = " + task.getArticleId());
    }

    public void delete(String id) {
        repository.deleteById(id);
        log.info("Удалена задача с ID = " + id);
    }
}
