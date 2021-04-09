package com.chemcool.school.article.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

/**
 * Entity articles
 *
 * @autor Иван Полещук
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "articles")
public class ArticlesTask {

    @Id
    @Column(name = "article_id", unique = true)
    private String articleId; //Id статьи

    @Column(name = "article_title", length = 300)
    @NonNull
    private String articleTitle; //заглавие статьи

    @Column(name = "article_body", length = 10000)
    @NonNull
    private String articleBody; //текст статьи

    @Column(name = "article_author", length = 50)
    private String articleAuthor; //автор статьи

    public static ArticlesTask createArticlesTask(ArticlesTaskExample task) {
        return new ArticlesTask(
                UUID.randomUUID().toString(),
                task.getArticleTitle(),
                task.getArticleBody(),
                task.getArticleAuthor()
        );
    }
}
