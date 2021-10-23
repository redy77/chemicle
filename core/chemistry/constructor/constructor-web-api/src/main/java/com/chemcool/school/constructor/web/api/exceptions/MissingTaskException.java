package com.chemcool.school.constructor.web.api.exceptions;

public class MissingTaskException extends RuntimeException{
    public MissingTaskException(String message) {
        super(message);
    }
}
