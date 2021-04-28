package com.chemcool.school.tasks.chemfixedanswer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiWebRestControllerExceptionHandler {

    @ExceptionHandler
    private ResponseEntity<GeneralExceptionHandler> generalExceptionHandler(Exception exception){
        return new ResponseEntity<>(new GeneralExceptionHandler(exception), HttpStatus.BAD_REQUEST);
    }

}
