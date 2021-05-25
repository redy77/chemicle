package com.chemcool.school.chat.service.service;

import com.chemcool.school.chat.service.models.ChatMessage;

import java.util.List;

public interface MessageService {
    String save(ChatMessage chatMessage);
    List<ChatMessage> findAllMessagesByRoomId(String id);
    ChatMessage edit(ChatMessage chatMessage);
    void delete(ChatMessage chatMessage);
}
