package com.chemcool.school.chat.web.api.controllers;

import com.chemcool.school.chat.service.models.ChatMessage;
import com.chemcool.school.chat.service.service.ChatMessageServiceImpl;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import java.util.Objects;

//@RestController
@Controller
public class ChatController {
    private final ChatMessageServiceImpl chatMessageService;

    public ChatController(ChatMessageServiceImpl chatMessageService) {

        this.chatMessageService = chatMessageService;
    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        System.out.println("SENDING A MESSAGE FOR SAVING FROM CHATCONTROLLER... ");
        chatMessageService.save(chatMessage);
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage,
                                  SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        Objects.requireNonNull(headerAccessor.getSessionAttributes()).put("username", chatMessage.getSenderName());
        return chatMessage;
    }

//    @GetMapping(value = "/check")
//    public String check() {
//        return "check";
//    }
}
