package com.chemcool.school.article.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Container for articles
 *
 * @autor Иван Полещук
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticlesTaskExample {
    private String articleTitle; //заглавие статьи
    private String articleBody; //текст статьи
    private String articleAuthor; //автор статьи
}
