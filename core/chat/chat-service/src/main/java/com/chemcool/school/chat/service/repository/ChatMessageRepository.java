package com.chemcool.school.chat.service.repository;

import com.chemcool.school.chat.service.domain.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RepositoryRestResource(path="messages")
public interface ChatMessageRepository extends JpaRepository<ChatMessage, String>, JpaSpecificationExecutor<ChatMessage> {
    @Query("select m from ChatMessage m where m.roomId = ?1")
    Optional<List<ChatMessage>> findAllMessagesByRoomId(String id);
}
