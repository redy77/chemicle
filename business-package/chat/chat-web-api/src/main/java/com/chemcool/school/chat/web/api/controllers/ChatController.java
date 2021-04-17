package com.chemcool.school.chat.web.api.controllers;

import com.chemcool.school.chat.service.dto.ChatMessageDto;
import com.chemcool.school.chat.service.service.ChatMessageService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

//@RestController
@Controller
public class ChatController {
    private ChatMessageService chatMessageService;

    public ChatController(ChatMessageService chatMessageService) {

        this.chatMessageService = chatMessageService;
    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessageDto sendMessage(@Payload ChatMessageDto chatMessageDto) {
        System.out.println("STARTING SAVING MESSAGE:..."+ chatMessageDto);
        System.out.println("STARTING SAVING MESSAGE:roomId..."+ chatMessageDto.getRoomId());
        System.out.println("STARTING SAVING MESSAGE:senderId..."+ chatMessageDto.getSenderId());
        System.out.println("STARTING SAVING MESSAGE:senderName..."+ chatMessageDto.getSenderName());
        System.out.println("STARTING SAVING MESSAGE:message..."+ chatMessageDto.getMessage());
        System.out.println("STARTING SAVING MESSAGE:type..."+ chatMessageDto.getType());
//        chatMessageService.save(chatMessageDto);
        System.out.println("MESSAGE SAVED "+chatMessageService.save(chatMessageDto));
        return chatMessageDto;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessageDto addUser(@Payload ChatMessageDto chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSenderName());
        return chatMessage;
    }

//    @GetMapping(value = "/check")
//    public String check() {
//        return "check";
//    }
}
