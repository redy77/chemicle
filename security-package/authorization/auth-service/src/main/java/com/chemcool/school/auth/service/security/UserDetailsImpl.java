package com.chemcool.school.auth.service.security;

import com.chemcool.school.auth.service.domain.UserAccountRole;
import com.chemcool.school.auth.service.domain.UserWithRegistration;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsImpl implements UserDetails {
    private String email;
    private String nickName;
    private String password;
    private UserAccountRole role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(role);
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public static UserDetails fromUserWithRegistration(UserWithRegistration user) {
        return new UserDetailsImpl(user.getEmail(), user.getNickname(), user.getPassword(), user.getRole());
    }
}

