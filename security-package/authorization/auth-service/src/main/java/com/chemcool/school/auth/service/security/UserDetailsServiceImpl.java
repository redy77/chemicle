package com.chemcool.school.auth.service.security;

import com.chemcool.school.auth.service.domain.UserWithRegistration;
import com.chemcool.school.auth.service.storage.UserWithRegistrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserWithRegistrationRepository userWithRegistrationRepository;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        UserWithRegistration user = userWithRegistrationRepository.findByEmail(userEmail);
        return UserDetailsImpl.fromUserWithRegistration(user);
    }
}
