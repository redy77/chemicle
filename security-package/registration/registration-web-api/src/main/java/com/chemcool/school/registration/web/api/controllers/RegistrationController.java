package com.chemcool.school.registration.web.api.controllers;

import com.chemcool.school.registration.exception.ApiResponse;
import com.chemcool.school.registration.exception.BadRequestException;
import com.chemcool.school.registration.repository.RegisterUserRepository;
import com.chemcool.school.registration.web.api.dto.RegisterUserDto;
import com.chemcool.school.registration.web.api.service.RegisterUserPresentation;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Slf4j
@RestController
@RequestMapping("/auth")
public class RegistrationController {

    private final RegisterUserPresentation registerUserPresentation;

    private final RegisterUserRepository repository;

    @Autowired
    public RegistrationController(RegisterUserPresentation registerUserPresentation, RegisterUserRepository repository) {
        this.registerUserPresentation = registerUserPresentation;
        this.repository = repository;
    }

    @ApiOperation("Регистрация нового пользователя")
    @PostMapping("/registration")
    public ResponseEntity<?> createUser(@Validated @RequestBody RegisterUserDto registerUserDto) {

        if(repository.existsByEmail(registerUserDto.getEmail())) {
            throw new BadRequestException("Email адрес уже был зарегистрирован!");
        }

        log.info("Вызван контроллер для регистрации нового пользователя c email: "
                + "[" + registerUserDto.getEmail() + "]");

        String result = registerUserPresentation.add(registerUserDto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/user/profile")
                .buildAndExpand(result).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "Пользователь успешно зарегистрирован"));
    }
}