package com.chemcool.school.chat.service.service;

import com.chemcool.school.chat.service.models.ChatMessage;

public interface ChatMessageService {
    Boolean save(ChatMessage chatMessage);
}
