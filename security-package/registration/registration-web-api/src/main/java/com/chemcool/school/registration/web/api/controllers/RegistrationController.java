package com.chemcool.school.registration.web.api.controllers;

import com.chemcool.school.registration.web.api.dto.RegisterUserDto;
import com.chemcool.school.registration.web.api.service.RegisterUserPresentation;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping()
public class RegistrationController {

    private final RegisterUserPresentation registerUserPresentation;

    @Autowired
    public RegistrationController(RegisterUserPresentation registerUserPresentation) {
        this.registerUserPresentation = registerUserPresentation;
    }

    @ApiOperation("Регистрация нового пользователя")
    @PostMapping("/registration")
    @ResponseBody
    public String createUser(@Validated @RequestBody RegisterUserDto registerUserDto) {

        log.info("Вызван контроллер для регистрации нового пользователя c email: "
                + "[" + registerUserDto.getEmail() + "]");
        return registerUserPresentation.add(registerUserDto);
    }
}
