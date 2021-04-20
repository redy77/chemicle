package com.chemcool.school.chat.service.service;

import com.chemcool.school.chat.service.models.ChatMessage;
import com.chemcool.school.chat.service.models.ChatUser;
import com.chemcool.school.chat.service.repository.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.UUID;

//@Slf4j
@Service
//@RequiredArgsConstructor
public class ChatMessageServiceImpl implements ChatMessageService {
    private final ChatMessageRepository messageRepository;
    private final ChatUserServiceImpl chatUserService;

    public ChatMessageServiceImpl(ChatMessageRepository messageRepository,ChatUserServiceImpl chatUserService ) {
        this.messageRepository = messageRepository;
        this.chatUserService = chatUserService;
    }


    @Override
    public Boolean save(ChatMessage chatMessage) {
        System.out.println("Started looking for users... ");
        ChatUser user = chatUserService.findByUserName(chatMessage.getSenderName());
        System.out.println("Found user... " + user);

        chatMessage.setId(UUID.randomUUID().toString());
        chatMessage.setTimestamp(new Timestamp(System.currentTimeMillis()));
        chatMessage.setUser(user);
        chatMessage.setType(ChatMessage.MessageType.CHAT);

        System.out.println("MESSAGE TO BE SAVED: " + chatMessage);
        ChatMessage result = messageRepository.save(chatMessage);
        System.out.println("Message saved " + result.getUser());
//        log.info("Message с ID: " + chatMessage.getId() + "  добавлен.");
        return true;
    }
}
