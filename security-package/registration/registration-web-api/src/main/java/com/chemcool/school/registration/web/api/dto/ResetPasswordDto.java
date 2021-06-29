package com.chemcool.school.registration.web.api.dto;

import com.chemcool.school.registration.annotations.ValidPassword;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResetPasswordDto {

    private String email;

    private String token;

    @ValidPassword
    private String password;
}
