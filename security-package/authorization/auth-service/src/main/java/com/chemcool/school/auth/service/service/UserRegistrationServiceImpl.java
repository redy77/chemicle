package com.chemcool.school.auth.service.service;

import com.chemcool.school.auth.service.domain.UserWithRegistration;
import com.chemcool.school.auth.service.storage.UserWithRegistrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRegistrationServiceImpl implements UserRegistrationService{
    private final UserWithRegistrationRepository userWithRegistrationRepository;

    @Override
    public void handleTask(UserWithRegistration userWithRegistration) {
        userWithRegistrationRepository.save(userWithRegistration);
    }
}
