package com.chemcool.school.tasks;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiWebRestControllerExceptionHandler {

    @ExceptionHandler
    private ResponseEntity<Exception> generalExceptionHandler(Exception exception) {
        return new ResponseEntity<>(new Exception(exception), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    private ResponseEntity<RuntimeException> ChemEquationsAnswerHandler(RuntimeException exception) {
        return new ResponseEntity<>(new RuntimeException(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
