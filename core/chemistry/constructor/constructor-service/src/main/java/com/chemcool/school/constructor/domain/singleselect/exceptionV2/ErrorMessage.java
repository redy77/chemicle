package com.chemcool.school.constructor.domain.singleselect.exceptionV2;


import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
class ErrorMessage {

    private String message;
    private org.springframework.http.HttpStatus HttpStatus;
}