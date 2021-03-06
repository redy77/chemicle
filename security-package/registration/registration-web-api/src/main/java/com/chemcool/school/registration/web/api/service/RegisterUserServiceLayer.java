package com.chemcool.school.registration.web.api.service;

import com.chemcool.school.registration.domain.*;
import com.chemcool.school.registration.service.RegisterUserProxyService;
import com.chemcool.school.registration.web.api.dto.RegisterUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegisterUserServiceLayer {

    private final RegisterUserProxyService registerUserProxyService;

    public String saveBeforeVerification(RegisterUserDto registerUserDto) {

        return registerUserProxyService.saveBeforeVerification(
                new RegisterUserExample(
                        UUID.randomUUID().toString(),
                        registerUserDto.getName(),
                        registerUserDto.getSurname(),
                        registerUserDto.getBirthday(),
                        registerUserDto.getGender(),
                        registerUserDto.getPhone(),
                        registerUserDto.getEmail(),
                        registerUserDto.getPassword(),
                        null,
                        RegisterUserAuthProvider.local,
                        null,
                        RegisterUserAccountType.BASE,
                        RegisterUserAccountRole.ROLE_USER_BASE,
                        registerUserDto.getVerificationCode(),
                        registerUserDto.isEnabled()
                )
        );
    }
}
