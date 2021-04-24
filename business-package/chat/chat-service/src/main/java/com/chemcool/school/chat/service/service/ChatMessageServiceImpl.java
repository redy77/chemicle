package com.chemcool.school.chat.service.service;

import com.chemcool.school.chat.service.miscelaneous.MessageType;
import com.chemcool.school.chat.service.models.ChatMessage;
import com.chemcool.school.chat.service.models.ChatUser;
import com.chemcool.school.chat.service.repository.ChatMessageRepository;

import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatMessageServiceImpl implements ChatMessageService {
    private final ChatMessageRepository messageRepository;
    private final ChatUserServiceImpl chatUserService;

    @Override
    public Boolean save(ChatMessage chatMessage) {
        ChatUser user = chatUserService.findByUserName(chatMessage.getSenderName());

        chatMessage.setId(UUID.randomUUID().toString());
        chatMessage.setTimestamp(new Timestamp(System.currentTimeMillis()));
        chatMessage.setUser(user);
        chatMessage.setType(MessageType.CHAT);

        ChatMessage result = messageRepository.save(chatMessage);
        log.info("Message с ID: " + chatMessage.getId() + "  добавлен.");
        return true;
    }
}
