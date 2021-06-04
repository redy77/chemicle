package com.chemcool.school.chat.web.api.controllers;

import com.chemcool.school.chat.service.domain.ChatMessage;
import com.chemcool.school.chat.service.service.ChatMessageService;
import com.chemcool.school.chat.service.service.ChatUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class WebSocketController {
    private final ChatMessageService chatMessageService;
    private final ChatUserService chatUserService;

    @MessageMapping("/chat.sendMessage")
    @SendTo("/chat-application/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        chatMessageService.save(chatMessage);
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/chat-application/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) {
        Objects.requireNonNull(headerAccessor.getSessionAttributes()).put("username", chatMessage.getSenderName());
        return chatMessage;
    }

    @GetMapping("/room/{id}/messages")
    public List<ChatMessage> getAllMessagesByRoomId(@PathVariable String id) {
        return chatMessageService.findAllMessagesByRoomId(id);
    }

}
