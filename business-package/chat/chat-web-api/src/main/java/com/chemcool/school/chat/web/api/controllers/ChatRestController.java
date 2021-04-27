package com.chemcool.school.chat.web.api.controllers;

import com.chemcool.school.chat.service.models.ChatUser;
import com.chemcool.school.chat.service.service.ChatUserServiceImpl;
import com.chemcool.school.chat.web.api.jwt.TokenParser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class ChatRestController {
    private final TokenParser tokenParser;
    private final ChatUserServiceImpl chatUserService;
    private final String AUTHORIZATION_HEADER = "Authorization";

    public ChatRestController(TokenParser tokenParser, ChatUserServiceImpl chatUserService) {
        this.tokenParser = tokenParser;
        this.chatUserService = chatUserService;
    }

    @GetMapping("/allUsers")
    public ResponseEntity<String> getAllUsers() {
        List<ChatUser> users = chatUserService.findAllUsers();
        return ResponseEntity.ok().body(users.toString());
    }
}
