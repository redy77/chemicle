package com.chemcool.school.article.web.api.exception;

/**
 * Empty-Exception Handler
 *
 * @autor Иван Полещук
 */
public class ArticleEmptyException extends RuntimeException {
    public ArticleEmptyException(String message) {
        super(message);
    }
}
