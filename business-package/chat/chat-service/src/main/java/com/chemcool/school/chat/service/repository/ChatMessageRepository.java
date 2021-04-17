package com.chemcool.school.chat.service.repository;

import com.chemcool.school.chat.service.models.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, UUID>, JpaSpecificationExecutor<ChatMessage> {
//    Optional<ChatMessage> findByElementNumber(int elementNumber);
}
