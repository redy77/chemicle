package com.chemcool.school.auth.service.domain;

import org.springframework.security.core.GrantedAuthority;

public enum RegisterUserAccountRole implements GrantedAuthority {
    ROLE_USER_BASE("ROLE_USER_BASE"),
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_TEACHER("ROLE_TEACHER"),
    ROLE_STUDENT("ROLE_STUDENT");

    private String role;

    RegisterUserAccountRole(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role;
    }
}
