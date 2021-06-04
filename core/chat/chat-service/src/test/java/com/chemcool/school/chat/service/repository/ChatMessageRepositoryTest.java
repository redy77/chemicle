package com.chemcool.school.chat.service.repository;

import com.chemcool.school.chat.service.miscelaneous.MessageType;
import com.chemcool.school.chat.service.domain.ChatMessage;
import com.chemcool.school.chat.service.domain.ChatUser;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ChatMessageRepositoryTest {

    private ChatMessageRepository underTest;

    ChatMessageRepositoryTest(ChatMessageRepository underTest) {
        this.underTest = underTest;
    }

    @Test
    void itShouldCheckIfMessageExists() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        ChatMessage message = new ChatMessage("1", new ChatUser(), "1", "Peter", "1", "Привет Петя", timestamp, MessageType.CHAT);

        underTest.save(message);
        ChatMessage foundMessage = null;
        Optional<ChatMessage> result = underTest.findById("1");

        if(result.isPresent()){
            foundMessage = result.get();
        }

        String getMessage = foundMessage.getMessage();

        String expected  = "Привет Петя";
        assertThat(getMessage).isNotNull().isEqualTo(expected);
    }

}