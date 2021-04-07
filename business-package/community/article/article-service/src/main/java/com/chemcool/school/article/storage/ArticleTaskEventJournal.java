package com.chemcool.school.article.storage;

import com.chemcool.school.article.domain.ArticleTaskEvent;
import com.chemcool.school.article.domain.ArticlesTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * interface for save event journal for articles
 *
 * @autor Иван Полещук
 */
public interface ArticleTaskEventJournal extends JpaRepository<ArticleTaskEvent, String>, JpaSpecificationExecutor<ArticlesTask> {
}