package com.chemcool.school.chat.web.api.controllers;

import com.chemcool.school.chat.service.models.ChatUser;
import com.chemcool.school.chat.service.service.ChatUserServiceImpl;
import com.chemcool.school.chat.web.api.jwt.TokenParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class ChatRestController {

    @Autowired
    private TokenParser tokenParser;

    private static final String AUTHORIZATION_HEADER = "Authorization";

    private final ChatUserServiceImpl chatUserService;

    public ChatRestController(ChatUserServiceImpl chatUserService) {
        this.chatUserService = chatUserService;
    }

    @GetMapping("/users")
    public ResponseEntity<String> getAllUsers(
            @RequestHeader(value = AUTHORIZATION_HEADER, required = false) String token) {

        System.out.println("UserId -> " + tokenParser.getUserIdFromToken(token));
        System.out.println("UserName -> " + tokenParser.getUserNameFromToken(token));
        System.out.println("UserRole -> " + tokenParser.getUserRoleFromToken(token));

        List<ChatUser> users = chatUserService.findAllUsers();
        return ResponseEntity.ok().body(users.toString());
    }
}
