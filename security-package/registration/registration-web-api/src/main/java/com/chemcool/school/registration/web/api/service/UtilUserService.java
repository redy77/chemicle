package com.chemcool.school.registration.web.api.service;

import com.chemcool.school.registration.domain.RegisterUserAccountRole;
import com.chemcool.school.registration.domain.RegisterUserAccountType;
import com.chemcool.school.registration.repository.RegisterUserRepository;
import com.chemcool.school.registration.web.api.dto.RegisterUserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UtilUserService {

    private final RegisterUserRepository repository;

    public boolean checkMail(RegisterUserDto registerUserDto) {
        return repository.existsByEmail(registerUserDto.getEmail());
    }

    public boolean checkPhone(RegisterUserDto registerUserDto) {
        return repository.existsByPhone(registerUserDto.getPhone());
    }

    public void checkAndSetRole(RegisterUserDto registerUserDto) {
        if (registerUserDto.getRole() == null) {
            registerUserDto.setRole(RegisterUserAccountRole.ROLE_USER_BASE);
        }
        if (registerUserDto.getType() == null) {
            registerUserDto.setType(RegisterUserAccountType.BASE);
        }
    }
}
