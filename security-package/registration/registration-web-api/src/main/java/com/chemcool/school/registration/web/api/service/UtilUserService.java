package com.chemcool.school.registration.web.api.service;

import com.chemcool.school.registration.domain.RegisterUserAccountRole;
import com.chemcool.school.registration.exception.BadRequestException;
import com.chemcool.school.registration.repository.RegisterUserRepository;
import com.chemcool.school.registration.web.api.dto.RegisterUserDto;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Slf4j
@Service
public class UtilUserService {

    private final RegisterUserRepository repository;

    public UtilUserService(RegisterUserRepository repository) {
        this.repository = repository;
    }

    public void checkMail(RegisterUserDto registerUserDto) {
        if (repository.existsByEmail(registerUserDto.getEmail())) {
            log.error("mail");
            throw new BadRequestException("Email адрес уже был зарегистрирован!");
        }
    }

    public void checkAge(RegisterUserDto registerUserDto) {

        log.info(registerUserDto.getBirthday().toString());
        if (Period.between(registerUserDto.getBirthday(), LocalDate.now()).getYears() < 18) {
            log.error("age");
            throw new BadRequestException("Вы не можете быть учителем, ваш возраст меньше 18 лет");
        }
    }

    public void checkAndSetRole(RegisterUserDto registerUserDto) {
        if (registerUserDto.getRole() == null) {
            log.error("role");
            registerUserDto.setRole(RegisterUserAccountRole.ROLE_USER_BASE);
        }
    }
}
