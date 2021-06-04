package com.chemcool.school.chat.service.repository;

import com.chemcool.school.chat.service.domain.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RepositoryRestResource(path="rooms")
public interface ChatRoomRepository extends JpaRepository<ChatRoom, String>, JpaSpecificationExecutor<ChatRoom> {
    @Query("select r from ChatRoom r join r.users u where u.id = ?1")
    List<ChatRoom> findAllRoomsByUserId(String id);

    @Query("select r from ChatRoom r where r.roomName = ?1")
    Optional<ChatRoom> findByRoomName(String name);
}
