package com.chemcool.school.auth.web.api.controllers;

import com.chemcool.school.auth.service.domain.RegisterUser;
import com.chemcool.school.auth.service.exeption.ResourceNotFoundException;
import com.chemcool.school.auth.service.security.CurrentUser;
import com.chemcool.school.auth.service.security.UserDetailsImpl;
import com.chemcool.school.auth.service.storage.RegisterUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class UserProfileControllerExample {

    private final RegisterUserRepository repository;


    @GetMapping("/user/profile")
    public RegisterUser getCurrentUser(@CurrentUser UserDetailsImpl userDetailsImpl) {
        return repository.findById(userDetailsImpl.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userDetailsImpl.getId()));
    }
}
