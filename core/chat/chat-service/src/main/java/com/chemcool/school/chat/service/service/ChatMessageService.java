package com.chemcool.school.chat.service.service;

import com.chemcool.school.chat.service.miscelaneous.MessageType;
import com.chemcool.school.chat.service.domain.ChatMessage;
import com.chemcool.school.chat.service.domain.ChatUser;
import com.chemcool.school.chat.service.repository.ChatMessageRepository;

import com.chemcool.school.chat.service.repository.ChatUserRepository;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatMessageService {
    private final ChatMessageRepository messageRepository;
    private final ChatUserRepository chatUserRepository;

    public String save(ChatMessage chatMessage) {

        ChatUser user = null;
        Optional<ChatUser> searchUserResult = chatUserRepository.findById(chatMessage.getSenderId());

        if (searchUserResult.isPresent()) {
            user = searchUserResult.get();
        } else {
            throw new RuntimeException("Невозможно найти пользователя по id: " + chatMessage.getSenderId());
        }
            chatMessage.setId(UUID.randomUUID().toString());
            chatMessage.setTimestamp(new Timestamp(System.currentTimeMillis()));
            chatMessage.setUser(user);
            chatMessage.setType(MessageType.CHAT);

            ChatMessage result = messageRepository.save(chatMessage);
            log.info("Сообщение с ID: " + chatMessage.getId() + "  добавлено.");
            return result.getId();

    }
    
    public List<ChatMessage> findAllMessagesByRoomId(String id){
        List<ChatMessage> foundMessagesByRoomId = new ArrayList<>();
        Optional<List<ChatMessage>> searchMessagesResult = messageRepository.findAllMessagesByRoomId(id);
        
        if (searchMessagesResult.isPresent()) {
            foundMessagesByRoomId = searchMessagesResult.get();
        }

        return foundMessagesByRoomId;
    }
}
