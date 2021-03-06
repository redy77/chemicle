package com.chemcool.school.registration.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserExample {

    private String userExampleName;
    private String userExampleSurname;
    private LocalDate userExampleBirthday;
    private String userExampleGender;
    private String userExamplePhone;
    private String userExampleEmail;
    private String userExamplePassword;
    private String imageUrl;
    private RegisterUserAuthProvider userExampleAuthProvider;
    private String userExampleProviderId;
    private RegisterUserAccountType userExampleType;
    private RegisterUserAccountRole userExampleRole;

}
