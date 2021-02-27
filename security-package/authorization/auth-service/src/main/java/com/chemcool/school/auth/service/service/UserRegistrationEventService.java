package com.chemcool.school.auth.service.service;

import com.chemcool.school.auth.service.domain.UserWithRegistrationEvent;

public interface UserRegistrationEventService {
    void handleEvent(UserWithRegistrationEvent event);
}
