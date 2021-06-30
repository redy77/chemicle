package com.chemcool.school.auth.service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class RegisterUser {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private RegisterUserAccountRole role;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "phone")
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type")
    private RegisterUserAccountType type;

    @Column(name = "gender")
    private String gender;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "provider")
    @Enumerated(EnumType.STRING)
    private RegisterUserAuthProvider provider;

    @Column(name = "provider_id")
    private String providerId;

    @Column(name = "verification_code")
    private String verificationCode;

    @Column(name = "enabled")
    private boolean isEnabled;

    @Column(name = "reset_password_token")
    private String resetPasswordToken;
}
