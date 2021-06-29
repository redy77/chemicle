package com.chemcool.school.registration.web.api.service;

import com.chemcool.school.registration.domain.RegisterUserAccountRole;
import com.chemcool.school.registration.domain.RegisterUserAccountType;
import com.chemcool.school.registration.repository.RegisterUserRepository;
import com.chemcool.school.registration.web.api.dto.RegisterUserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Slf4j
@RequiredArgsConstructor
@Service
public class UtilUserService {

    private final RegisterUserRepository repository;

    public boolean checkMail(RegisterUserDto registerUserDto) {
        return repository.existsByEmail(registerUserDto.getEmail());
    }

    public String checkAge(RegisterUserDto registerUserDto) {
        String message = "";
        int age;
        if (registerUserDto.getBirthday() == null) {
            message += "Не указан возраст!\n";
        } else {
            age = Period.between(registerUserDto.getBirthday(), LocalDate.now()).getYears();
            if (age < 6 || age > 100) {
                message += "Недопустимый возраст!\n";
            } else if (age < 18 && registerUserDto.getRole() == RegisterUserAccountRole.ROLE_TEACHER) {
                message += "Ваш возраст меньше 18, вы не можете быть учителем!\n";
            }
        }
        return message;
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
