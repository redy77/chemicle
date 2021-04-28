package com.chemcool.school.tasks.chemequations.service;

/**
 * Обёртка для исключения
 *
 * @version 1.0
 * @autor Евгений Жиленков
 */
public class ChemEquationsTaskException extends RuntimeException {
    public ChemEquationsTaskException(String message) {
        super(message);
    }
}