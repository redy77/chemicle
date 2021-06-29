package com.chemcool.school.registration.web.api.service;

import com.chemcool.school.registration.domain.RegisterUserAccountRole;
import com.chemcool.school.registration.exception.ApiResponse;
import com.chemcool.school.registration.web.api.dto.RegisterUserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class RegistrationService {

    private final VerificationEmailService verificationEmailService;

    private final UtilUserService utilUserService;

    public ResponseEntity<?> createUser(RegisterUserDto registerUserDto) {
        String message = "";
        message += utilUserService.checkAge(registerUserDto);
        if (utilUserService.checkMail(registerUserDto)) {
            message += "Email адрес уже был зарегистрирован!\n";
        }
        if (registerUserDto.getPhone() != null && utilUserService.checkPhone(registerUserDto)) {
            message += "Номер телефона уже использован\n";
        }
        if (!message.isEmpty()) {
            return ResponseEntity.badRequest().body(message);
        }
        utilUserService.checkAndSetRole(registerUserDto);

        log.info("Вызван контроллер для регистрации нового пользователя c email: "
                + "[" + registerUserDto.getEmail() + "]");

        String result = verificationEmailService.sendVerificationEmail(registerUserDto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/user/profile")
                .buildAndExpand(result).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "Пользователь успешно зарегистрирован"));
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
