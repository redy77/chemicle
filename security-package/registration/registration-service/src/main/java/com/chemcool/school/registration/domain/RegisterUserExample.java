package com.chemcool.school.registration.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserExample {

    private String userExampleNick;
    private String userExampleName;
    private String userExampleSurname;
    private String userExampleCity;
    private String userExamplePhone;
    private String userExampleEmail;
    private String userExamplePassword;
    private RegisterUserAccountType userExampleType;
    private RegisterUserAccountRole userExampleRole;
}
