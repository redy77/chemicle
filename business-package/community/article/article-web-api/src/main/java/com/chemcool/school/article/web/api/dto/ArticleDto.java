package com.chemcool.school.article.web.api.dto;

import com.chemcool.school.article.domain.ArticlesTask;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Dto статей
 *
 * @autor Иван Полещук
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDto {
    private String articleId; //Id статьи
    private String articleTitle; //заглавие статьи
    private String articleBody; //текст статьи
    private String articleAuthor; //автор статьи

    public ArticleDto(ArticlesTask task) {
        this.articleId = task.getArticleId();
        this.articleTitle = task.getArticleTitle();
        this.articleBody = task.getArticleBody();
        this.articleAuthor = task.getArticleAuthor();
    }
}
