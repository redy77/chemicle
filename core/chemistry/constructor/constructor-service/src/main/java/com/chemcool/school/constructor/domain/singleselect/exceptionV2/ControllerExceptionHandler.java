package com.chemcool.school.constructor.domain.singleselect.exceptionV2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> resourceNotFoundException(ResourceNotFoundException e) {
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        ErrorMessage message = new ErrorMessage(e.getMessage(), notFound);
        return new ResponseEntity<>(message,notFound);
    }


//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorMessage> resourceNotFoundException(ResourceNotFoundException ex) {
//        ErrorMessage message = new ErrorMessage(ex.getMessage());
//
//        return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorMessage> globalExceptionHandler(Exception ex) {
//        ErrorMessage message = new ErrorMessage(ex.getMessage());
//
//        return new ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}