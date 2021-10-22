package com.chemcool.school.constructor.web.api.exceptions;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ErrorResponse {

    private List<String> errors;
    private String timestamp = LocalDateTime.now().toString();
}
