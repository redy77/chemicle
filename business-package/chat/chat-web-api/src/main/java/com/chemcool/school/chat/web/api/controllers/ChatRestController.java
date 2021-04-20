package com.chemcool.school.chat.web.api.controllers;

import com.chemcool.school.chat.service.models.ChatUser;
import com.chemcool.school.chat.service.service.ChatUserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class ChatRestController {

    private final ChatUserServiceImpl chatUserService;

    public ChatRestController(ChatUserServiceImpl chatUserService) {
        this.chatUserService = chatUserService;
    }

    @GetMapping("/users")
    public ResponseEntity<String> getAllUsers() {
        List<ChatUser> users = chatUserService.findAllUsers();
        return ResponseEntity.ok().body(users.toString());
    }
}
