package com.chemcool.school.chat.service.service;

import com.chemcool.school.chat.service.miscelaneous.MessageType;
import com.chemcool.school.chat.service.models.ChatMessage;
import com.chemcool.school.chat.service.models.ChatUser;
import com.chemcool.school.chat.service.repository.ChatMessageRepository;

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
    private final ChatUserService chatUserService;

    public String save(ChatMessage chatMessage) {
        ChatUser user = chatUserService.findByUserName(chatMessage.getSenderName());

        chatMessage.setId(UUID.randomUUID().toString());
        chatMessage.setTimestamp(new Timestamp(System.currentTimeMillis()));
        chatMessage.setUser(user);
        chatMessage.setType(MessageType.CHAT);

        ChatMessage result = messageRepository.save(chatMessage);
        log.info("Сообщение с ID: " + chatMessage.getId() + "  добавлено.");
        return result.getId();
    }

    public ChatMessage edit(ChatMessage chatMessage) {
        return messageRepository.save(chatMessage);
    }

    public void delete(ChatMessage chatMessage) {
        messageRepository.delete(chatMessage);
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
