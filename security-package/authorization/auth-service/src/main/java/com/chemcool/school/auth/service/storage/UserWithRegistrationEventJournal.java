package com.chemcool.school.auth.service.storage;


import com.chemcool.school.auth.service.domain.RegisterUserEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserWithRegistrationEventJournal extends JpaRepository<RegisterUserEvent, Long> {
}
