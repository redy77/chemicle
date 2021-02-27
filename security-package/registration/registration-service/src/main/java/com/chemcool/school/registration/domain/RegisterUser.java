package com.chemcool.school.registration.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class RegisterUser {

    @Id
    @Column(name = "id", unique = true)
    private String id;

    @NonNull
    @NotEmpty
    @Column(name = "nick")
    private String nick;

    @NonNull
    @NotEmpty
    @Column(name = "name")
    private String name;

    @NonNull
    @NotEmpty
    @Column(name = "surname")
    private String surname;

    @NonNull
    @NotEmpty
    @Column(name = "city")
    private String city;

    @NonNull
    @NotEmpty
    @Column(name = "phone")
    private String phone;

    @NotNull
    @NotEmpty
    @Email
    @Column(name = "email", unique = true)
    private String email;

    @NonNull
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
                example.getUserExampleType(),
                example.getUserExampleRole()
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
