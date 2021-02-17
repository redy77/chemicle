package com.chemcool.school.auth.service.domain;

import org.springframework.security.core.GrantedAuthority;

public enum UserAccountRole implements GrantedAuthority {
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN"),
    USER_BASE("ROLE_USER_BASE");


    private String role;

    UserAccountRole(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role;
    }
}
