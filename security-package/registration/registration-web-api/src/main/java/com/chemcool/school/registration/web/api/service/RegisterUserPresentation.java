package com.chemcool.school.registration.web.api.service;

import com.chemcool.school.registration.web.api.dto.RegisterUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterUserPresentation {

    private final RegisterUserServiceLayer registerUserServiceLayer;

    public String add(RegisterUserDto registerUserDto) {
        return registerUserServiceLayer.add(registerUserDto);
    }
}
