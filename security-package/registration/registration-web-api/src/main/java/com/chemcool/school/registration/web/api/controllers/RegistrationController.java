package com.chemcool.school.registration.web.api.controllers;

import com.chemcool.school.registration.exception.ApiResponse;
import com.chemcool.school.registration.exception.BadRequestException;
import com.chemcool.school.registration.repository.RegisterUserRepository;
import com.chemcool.school.registration.web.api.dto.RegisterUserDto;
import com.chemcool.school.registration.web.api.service.VerificationEmailService;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/auth")
public class RegistrationController {

    private final VerificationEmailService verificationEmailService;
    private final RegisterUserRepository repository;

    @Autowired
    public RegistrationController(VerificationEmailService verificationEmailService, RegisterUserRepository repository) {

        this.verificationEmailService = verificationEmailService;
        this.repository = repository;
    }

    @SneakyThrows
    @ApiOperation("Регистрация нового пользователя")
    @PostMapping("/registration")
    public ResponseEntity<?> createUser(@Validated @RequestBody RegisterUserDto registerUserDto) {

        if (repository.existsByEmail(registerUserDto.getEmail())) {
            throw new BadRequestException("Email адрес уже был зарегистрирован!");
        }

        log.info("Вызван контроллер для регистрации нового пользователя c email: "
                + "[" + registerUserDto.getEmail() + "]");

        String result = verificationEmailService.sendVerificationEmail(registerUserDto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/user/profile")
                .buildAndExpand(result).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "Пользователь успешно зарегистрирован"));
    }

    @ApiOperation("Активация аккаунта")
    @GetMapping("/verify")
    public ResponseEntity<?> verifyUser(@Param("code") String code) {
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