package com.chemcool.school.auth.web.api.dto;

import lombok.Data;

@Data
public class UserSendFromClient {

    private String email;
    private String password;
}
