package com.chemcool.school.games.twoofoureight.service;

import com.chemcool.school.games.twoofoureight.domain.User;
import com.chemcool.school.games.twoofoureight.storage.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository repository;

    public UserDetailsServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        User u = repository.getById(id);
        if (Objects.isNull(u)) {
            throw new UsernameNotFoundException(String.format("User %s is not found", id));
        }
        return new org.springframework.security.core.userdetails.User(u.getName(), "", true, true, true, true, new HashSet<>());
    }
}
