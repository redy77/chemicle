package com.chemcool.school.registration.web.api.controllers;

import com.chemcool.school.registration.web.api.dto.ResetPasswordDto;
import com.chemcool.school.registration.web.api.service.ResetPasswordService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class ResetPasswordController {

    private final ResetPasswordService resetPasswordService;

    @ApiOperation("отправляем ссылку сброса пароля на Email")
    @PostMapping("/forgot-password")
    public ResponseEntity<?> processForgotPassword(@Validated @RequestBody ResetPasswordDto resetPasswordDto) {
        return resetPasswordService.processForgotPassword(resetPasswordDto);
    }
    @ApiOperation("Потдверждение, для смены пароля")
    @GetMapping("/verify-reset")
    public ResponseEntity<?> processVerifyPassword(@Param("token") String token) {
        return resetPasswordService.processVerifyPassword(token);
    }

    @ApiOperation("Добавляем новый пароль пользователя")
    @PostMapping("/reset-password")
    public ResponseEntity<?> processResetPassword(@Validated @RequestBody ResetPasswordDto resetPasswordDto) {
        return resetPasswordService.processResetPassword(resetPasswordDto);
    }
}
