package com.chemcool.school.chat.service.repository;

import com.chemcool.school.chat.service.domain.ChatUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RepositoryRestResource(path="users")
public interface ChatUserRepository extends JpaRepository<ChatUser, String>, JpaSpecificationExecutor<ChatUser> {

    @Query("select u from ChatUser u join u.chatRooms r where r.id = ?1")
    Optional<List<ChatUser>> findAllUsersByRoomId(String id);

}
