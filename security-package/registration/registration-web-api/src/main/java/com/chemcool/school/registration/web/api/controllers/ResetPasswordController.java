package com.chemcool.school.registration.web.api.controllers;

import com.chemcool.school.registration.domain.RegisterUser;
import com.chemcool.school.registration.exception.ApiResponse;
import com.chemcool.school.registration.exception.BadRequestException;
import com.chemcool.school.registration.repository.RegisterUserRepository;
import com.chemcool.school.registration.web.api.dto.ForgotPasswordDto;
import com.chemcool.school.registration.web.api.service.ResetPasswordService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class ResetPasswordController {

    private final ResetPasswordService resetPasswordService;

    @ApiOperation("отправляем ссылку сброса пароля на Email")
    @PostMapping("/forgot-password")
    public ResponseEntity<?> processForgotPassword(@Validated @RequestBody ForgotPasswordDto forgotPasswordDto) {
        return resetPasswordService.processForgotPassword(forgotPasswordDto);
    }

    @ApiOperation("Добавляем новый пароль пользователя")
    @PostMapping("/reset-password")
    public ResponseEntity<?> processResetPassword(@RequestBody ForgotPasswordDto forgotPasswordDto) {
        return resetPasswordService.processResetPassword(forgotPasswordDto);
    }
}
