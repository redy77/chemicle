package com.chemcool.school.registration.web.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserDto {
    private String id;
    private String nick;
    private String name;
    private String surname;
    private String city;
    private String phone;
    private String email;
    private String password;
}
