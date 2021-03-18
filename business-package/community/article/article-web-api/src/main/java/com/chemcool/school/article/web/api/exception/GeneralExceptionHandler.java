package com.chemcool.school.article.web.api.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Part exception handler
 *
 * @version 1.0
 * @autor Иван Полещук
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneralExceptionHandler {
    private String message;

    public GeneralExceptionHandler(Exception exception) {
        this.message = exception.getMessage();
    }
}
