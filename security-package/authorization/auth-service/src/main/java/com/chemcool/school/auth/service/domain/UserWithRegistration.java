package com.chemcool.school.auth.service.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users_registration")
public class UserWithRegistration {
    @Id
    @Column(name = "user_id")
    private String id;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_nick_name")
    private String nickname;

    @Column(name = "user_password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private UserAccountRole role;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_surname")
    private String surname;

    @Column(name = "user_city")
    private String city;

    @Column(name = "user_phone_number")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_account_type")
    private UserAccountType userAccountType;
}
