package com.chemcool.school.registration.web.api.service;

import com.chemcool.school.registration.domain.RegisterUserAccountRole;
import com.chemcool.school.registration.domain.RegisterUserAccountType;
import com.chemcool.school.registration.domain.RegisterUserExample;
import com.chemcool.school.registration.service.RegisterUserProxyService;
import com.chemcool.school.registration.web.api.dto.RegisterUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterUserServiceLayer {

    private final RegisterUserProxyService registerUserProxyService;

    public String add(RegisterUserDto registerUserDto) {

        return registerUserProxyService.add(
                new RegisterUserExample(
                        registerUserDto.getNick(),
                        registerUserDto.getName(),
                        registerUserDto.getSurname(),
                        registerUserDto.getCity(),
                        registerUserDto.getPhone(),
                        registerUserDto.getEmail(),
                        registerUserDto.getPassword(),
                        RegisterUserAccountType.BASE,
                        RegisterUserAccountRole.ROLE_USER
                )
        );
    }
}
