package com.chemcool.school.registration.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class RegisterUser {

    @Id
    @Column(name = "id", unique = true)
    private String id;

    @Column(name = "nick")
    private String nick;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "city")
    private String city;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private RegisterUserAccountType type;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private RegisterUserAccountRole role;

    public static RegisterUser createUser(
            RegisterUserExample example
    ) {
        return new RegisterUser(
                UUID.randomUUID().toString(),
                example.getUserExampleNick(),
                example.getUserExampleName(),
                example.getUserExampleSurname(),
                example.getUserExampleCity(),
                example.getUserExamplePhone(),
                example.getUserExampleEmail(),
                example.getUserExamplePassword(),
                RegisterUserAccountType.BASE,
                RegisterUserAccountRole.ROLE_USER
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegisterUser registerUser = (RegisterUser) o;
        return id.equals(registerUser.id);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
}
