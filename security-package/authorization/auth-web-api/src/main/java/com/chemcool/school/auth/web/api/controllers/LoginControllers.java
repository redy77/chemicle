package com.chemcool.school.auth.web.api.controllers;

import com.chemcool.school.auth.service.security.JwtUtil;
import com.chemcool.school.auth.web.api.dto.LoginRequest;
import com.chemcool.school.auth.web.api.dto.UserView;
import com.chemcool.school.auth.web.api.dto.UserViewMapper;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class LoginControllers {

    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;
    private final UserViewMapper userViewMapper;


    @ApiOperation("Возвращает: header(Authorization: Bearer jwt) и UserView")
    @PostMapping("/login")
    public ResponseEntity<UserView> authenticateUser(@RequestBody LoginRequest request) {

        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken( request.getEmail(), request.getPassword() )
        );

        SecurityContextHolder.getContext().setAuthentication(auth);

        return ResponseEntity.ok()
                .header(
                        HttpHeaders.AUTHORIZATION, "Bearer " + jwtUtil.generateJwt(auth)
                )
                .body(
                        userViewMapper.toUserView( (UserDetails) auth.getPrincipal() )
                );
    }

}
