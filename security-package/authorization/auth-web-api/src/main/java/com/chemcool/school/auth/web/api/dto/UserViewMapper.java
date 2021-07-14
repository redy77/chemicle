package com.chemcool.school.auth.web.api.dto;

import com.chemcool.school.auth.service.security.UserDetailsImpl;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserViewMapper {

    UserView toUserView(UserDetailsImpl details);

}
