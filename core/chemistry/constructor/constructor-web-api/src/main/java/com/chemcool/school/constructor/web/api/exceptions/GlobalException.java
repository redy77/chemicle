package com.chemcool.school.constructor.web.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler
    public ResponseEntity<InfoTaskDate> handleExceptions(MissingTaskException exception) {
        InfoTaskDate infoTaskDate = new InfoTaskDate();
        infoTaskDate.setMessage(exception.getMessage());
        return new ResponseEntity<>(infoTaskDate, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<InfoTaskDate> handleExceptions(Exception exception) {
        InfoTaskDate infoTaskDate = new InfoTaskDate();
        infoTaskDate.setMessage(exception.getMessage());
        return new ResponseEntity<>(infoTaskDate, HttpStatus.BAD_REQUEST);
    }
}
