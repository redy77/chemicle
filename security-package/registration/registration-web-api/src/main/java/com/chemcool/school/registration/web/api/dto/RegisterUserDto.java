package com.chemcool.school.registration.web.api.dto;

import com.chemcool.school.registration.annotations.ValidPassword;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserDto {

    @NonNull
    @NotEmpty
    private String nick;

    @NonNull
    @NotEmpty
    private String name;

    @NonNull
    @NotEmpty
    private String surname;

    @NonNull
    @NotEmpty
    private String city;

    @NonNull
    @NotEmpty
    private String phone;

    @NotNull
    @NotEmpty
    @Email
    private String email;

    @NonNull
    @ValidPassword
    private String password;

}
