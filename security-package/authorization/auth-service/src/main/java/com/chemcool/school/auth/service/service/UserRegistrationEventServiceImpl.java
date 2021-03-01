package com.chemcool.school.auth.service.service;

import com.chemcool.school.auth.service.domain.RegisterUserEvent;
import com.chemcool.school.auth.service.storage.UserWithRegistrationEventJournal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRegistrationEventServiceImpl implements UserRegistrationEventService {
    private final UserWithRegistrationEventJournal userWithRegistrationEventJournal;

    public void handleEvent(RegisterUserEvent event) {
        userWithRegistrationEventJournal.save(event);
    }
}
