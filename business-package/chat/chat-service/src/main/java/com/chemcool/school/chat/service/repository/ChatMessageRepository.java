package com.chemcool.school.chat.service.repository;

import com.chemcool.school.chat.service.models.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path="messages")
public interface ChatMessageRepository extends JpaRepository<ChatMessage, String>, JpaSpecificationExecutor<ChatMessage> {
//    Optional<ChatMessage> findByElementNumber(String elementNumber);
}