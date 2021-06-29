package com.chemcool.school.registration.web.api.service;

import com.chemcool.school.registration.domain.RegisterUserAccountRole;
import com.chemcool.school.registration.exception.ApiResponse;
import com.chemcool.school.registration.exception.RegisterUserDefinitionException;
import com.chemcool.school.registration.web.api.dto.RegisterUserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class RegistrationService {

    private final VerificationEmailService verificationEmailService;

    private final UtilUserService utilUserService;

    public ResponseEntity<?> createUser(RegisterUserDto registerUserDto) {
        Map<String, String> errors = new HashMap<>();
        int age;

        if (utilUserService.checkMail(registerUserDto)) {
            errors.put("email", "Email адрес уже был зарегистрирован!");
        }
        if (registerUserDto.getPhone() != null && utilUserService.checkPhone(registerUserDto)) {
            errors.put("phone", "Номер телефона уже использован");
        }
        if (registerUserDto.getBirthday() != null) {
            age = Period.between(registerUserDto.getBirthday(), LocalDate.now()).getYears();
            if (age < 18 && registerUserDto.getRole() == RegisterUserAccountRole.ROLE_TEACHER) {
                errors.put("role", "Ваш возраст меньше 18, вы не можете быть учителем!");
            }
        } else {
            if (registerUserDto.getRole() == RegisterUserAccountRole.ROLE_TEACHER) {
                errors.put("age", "Вы не указали возраст, вы не можете быть учителем");
            }
        }
        if (!errors.isEmpty()) {
            return ResponseEntity.badRequest().body(new ApiResponse(errors, "VALIDATION_FAILED"));
        }
        utilUserService.checkAndSetRole(registerUserDto);

        log.info("Вызван контроллер для регистрации нового пользователя c email: "
                + "[" + registerUserDto.getEmail() + "]");

        String result = verificationEmailService.sendVerificationEmail(registerUserDto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/user/profile")
                .buildAndExpand(result).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "Пользователь успешно зарегистрирован", false));
    }

    public ResponseEntity<?> verifyUser(String code) {
        Map<String, String> response = new HashMap<>();
        if (verificationEmailService.verify(code)) {
            response.put("isValidated", "Активация аккаунта успешна");
            return ResponseEntity.accepted().body(response);
        } else {
            response.put("isValidated", "Не удалось активировать аккаунт");
            return ResponseEntity.badRequest().body(response);
        }
    }
}
