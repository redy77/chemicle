package com.chemcool.school.chat.service.service;

import com.chemcool.school.chat.service.models.ChatMessage;
import com.chemcool.school.chat.service.models.ChatUser;
import com.chemcool.school.chat.service.repository.ChatMessageRepository;
import com.chemcool.school.chat.service.dto.ChatMessageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.UUID;

//@Slf4j
@Service("ChatMessageService")
@RequiredArgsConstructor
public class ChatMessageService {
    public ChatMessageRepository messageRepository;


    public Boolean save(ChatMessageDto chatMessageDto) {

        ChatUser user = new ChatUser("2", "Alan", "Student");
        ChatMessage chatMessage = new ChatMessage(
                UUID.randomUUID().toString(),
                user,
                chatMessageDto.getRoomId(),
                chatMessageDto.getSenderName(),
                chatMessageDto.getMessage(),
                new Timestamp(System.currentTimeMillis()));
        System.out.println("MESSAGE TO BE SAVED: " + chatMessage);
        messageRepository.save(chatMessage);
        System.out.println("Message saved ");
//        log.info("Message с ID: " + chatMessage.getId() + "  добавлен.");
        return true;
    }
}
