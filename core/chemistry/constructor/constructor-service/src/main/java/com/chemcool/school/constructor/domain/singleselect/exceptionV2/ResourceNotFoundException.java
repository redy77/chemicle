package com.chemcool.school.constructor.domain.singleselect.exceptionV2;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}