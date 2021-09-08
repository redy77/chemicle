package com.chemcool.school.constructor.domain.singleselect.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class SingleSelectControllerException {




    @ExceptionHandler
    private ResponseEntity<GeneralExceptionHandler> generalExceptionHandler(Exception exception) {
        return new ResponseEntity<>(new GeneralExceptionHandler(exception), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    private ResponseEntity<SingleSelectTaskException> ChemEquationsAnswerHandler(SingleSelectTaskException exception) {
        return new ResponseEntity<>(new SingleSelectTaskException(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
