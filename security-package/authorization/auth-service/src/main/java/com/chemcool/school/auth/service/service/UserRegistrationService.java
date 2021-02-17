package com.chemcool.school.auth.service.service;

import com.chemcool.school.auth.service.domain.UserWithRegistration;

public interface UserRegistrationService {
    void handleTask(UserWithRegistration userWithRegistration);
}
