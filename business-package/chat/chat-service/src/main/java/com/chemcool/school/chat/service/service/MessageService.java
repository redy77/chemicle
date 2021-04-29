package com.chemcool.school.chat.service.service;

import com.chemcool.school.chat.service.models.ChatMessage;

public interface MessageService {
    String save(ChatMessage chatMessage);
}
