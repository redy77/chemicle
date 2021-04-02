package com.chemcool.school.article.web.api.exception;

/**
 * Part of exception handler
 *
 * @autor Иван Полещук
 */
public class ArticleEmptyException extends RuntimeException {
    public ArticleEmptyException(String message) {
        super(message);
    }
}
