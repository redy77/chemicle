package com.chemcool.school.auth.web.api.dto;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.springframework.security.core.userdetails.UserDetails;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserViewMapper {

    UserView toUserView(UserDetails details);

}
