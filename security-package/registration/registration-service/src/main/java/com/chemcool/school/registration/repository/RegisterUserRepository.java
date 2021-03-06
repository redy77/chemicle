package com.chemcool.school.registration.repository;

import com.chemcool.school.registration.domain.RegisterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegisterUserRepository extends JpaRepository<RegisterUser, String> {
    Boolean existsByEmail(String email);

    Optional<RegisterUser> findByEmail(String email);
}
