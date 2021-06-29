package com.chemcool.school.registration.web.api.service;

import com.chemcool.school.registration.domain.RegisterUser;
import com.chemcool.school.registration.domain.RegisterUserEventFactory;
import com.chemcool.school.registration.domain.RegisterUserEventType;
import com.chemcool.school.registration.exception.ApiResponse;
import com.chemcool.school.registration.exception.BadRequestException;
import com.chemcool.school.registration.exception.RegisterUserDefinitionException;
import com.chemcool.school.registration.repository.RegisterUserRepository;
import com.chemcool.school.registration.service.RegisterUserEventNotificationService;
import com.chemcool.school.registration.web.api.dto.ResetPasswordDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
public class ResetPasswordService {

    @Autowired
    RegisterUserEventNotificationService registerUserEventNotificationService;
    @Autowired
    private RegisterUserRepository repository;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Value("${your.path.yml.stringPassword}")
    private String resetPasswordUrl;

    public ResponseEntity<?> processVerifyPassword(String token) {
        RegisterUser registerUser = repository.findByResetPasswordToken(token);
        Map<String, String> response = new HashMap<>();

        if (registerUser != null) {
            response.put("isValidated", "Пароль может быть изменен");
            registerUser.setResetPasswordToken(token + "verify");
            return ResponseEntity.accepted().body(response);
        } else {
            throw new BadRequestException("Неверная ссылка, либо истек срок действия ссылки");
        }
    }

    public ResponseEntity<?> processForgotPassword(ResetPasswordDto resetPasswordDto) {
        if (!repository.existsByEmail(resetPasswordDto.getEmail())) {
            throw new BadRequestException("Email адрес не был зарегистрирован!");
        }

        log.info("Вызван контроллер для сброса пароля на email: "
                + "[" + resetPasswordDto.getEmail() + "]");

        String result = sendForgotPasswordEmail(resetPasswordDto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/")
                .buildAndExpand(result).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "Письмо для сброса пароля успешно отправлено"));
    }

    public ResponseEntity<?> processResetPassword(ResetPasswordDto resetPasswordDto) {
        String password = resetPasswordDto.getPassword();
        RegisterUser registerUser = repository.findByEmail(resetPasswordDto.getEmail());
        String token = registerUser.getResetPasswordToken();

        if (registerUser.getResetPasswordToken().contains(token)
                &&registerUser.getResetPasswordToken().contains("verify")) {
            updatePassword(registerUser, password);
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/")
                .buildAndExpand(registerUser.getId()).toUri();
        registerUser.setResetPasswordToken(null);
        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "Пароль был успешно изменен!"));
    }

    public String sendForgotPasswordEmail(ResetPasswordDto resetPasswordDto) {

        final String email = resetPasswordDto.getEmail();
        final String token = UUID.randomUUID().toString();

        RegisterUser registerUser = repository.findByEmail(email);
        if (registerUser != null) {
            registerUser.setResetPasswordToken(token);
            repository.save(registerUser);
        } else {
            throw new RegisterUserDefinitionException("Пользователь с таким Email не найден " + email);
        }

        new Thread(() -> {
            try {
                String fromAddress = "borara3511@gmail.com";
                String senderName = "ChemCool";
                String subject = "Восстановление пароля на сайте ChemCool.ru";
                String content = "<p>Здравствуйте.</p>"
                        + "<p>Перейдите пожалуйста по ссылке ниже для сброса пароля:</p>"
                        + "<h3><a href=\"[[URL]]\" target=\"_self\">ВОССТАНОВИТЬ ПАРОЛЬ</a></h3>"
                        + "<br>"
                        + "<p>Игнорируйте это письмо если вы не запрашивали сброс пароля.</p>"
                        + "Рады, что Вы с нами!<br>"
                        + "ChemCool.ru";

                MimeMessage message = mailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(message);

                helper.setFrom(fromAddress, senderName);
                helper.setTo(email);
                helper.setSubject(subject);

                resetPasswordUrl += token;

                content = content.replace("[[URL]]", resetPasswordUrl);

                helper.setText(content, true);
                mailSender.send(message);
            } catch (IOException | MessagingException e) {
                e.printStackTrace();
            }
        }).start();

        return registerUser.getId();
    }

    public void updatePassword(RegisterUser registerUser, String password) {

        registerUser.setPassword(passwordEncoder.encode(password));
        registerUser.setResetPasswordToken(null);
        log.info("Пользователь {} успешно изменил пароль", registerUser.getEmail());
        registerUserEventNotificationService.send(
                RegisterUserEventFactory.createEvent(registerUser, RegisterUserEventType.UPDATE)
        );
    }

}
