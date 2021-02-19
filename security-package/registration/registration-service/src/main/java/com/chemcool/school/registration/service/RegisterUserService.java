package com.chemcool.school.registration.service;

import com.chemcool.school.registration.domain.RegisterUser;
import org.springframework.stereotype.Service;

@Service
public interface RegisterUserService {

    void save(RegisterUser registerUser);
}
