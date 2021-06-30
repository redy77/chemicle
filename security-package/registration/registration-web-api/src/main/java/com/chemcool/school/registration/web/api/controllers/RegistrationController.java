package com.chemcool.school.registration.web.api.controllers;

import com.chemcool.school.registration.web.api.dto.RegisterUserDto;
import com.chemcool.school.registration.web.api.service.RegistrationService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class RegistrationController {

    private final RegistrationService registrationService;

    @SneakyThrows
    @ApiOperation("Регистрация нового пользователя")
    @PostMapping("/registration")
    public ResponseEntity<?> createUser(@Validated @RequestBody RegisterUserDto registerUserDto) {
        return registrationService.createUser(registerUserDto);
    }


    @ApiOperation("Активация аккаунта")
    @GetMapping("/verify")
    public ResponseEntity<?> verifyUser(@Param("code") String code) {
        return registrationService.verifyUser(code);
    }
}