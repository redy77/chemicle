package com.chemcool.school.auth.service.storage;

import com.chemcool.school.auth.service.domain.RegisterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserWithRegistrationRepository extends JpaRepository<RegisterUser, Long> {
    RegisterUser findByEmail(String userEmail);
}
