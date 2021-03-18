package com.chemcool.school.article.storage;

import com.chemcool.school.article.domain.ArticlesTask;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for saving articles to the db
 *
 * @autor Иван Полещук
 */
public interface ArticleTaskRepository extends JpaRepository<ArticlesTask, String> {
}
