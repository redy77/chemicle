package com.chemcool.school.chat.service.repository;

import com.chemcool.school.chat.service.models.ChatUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RepositoryRestResource(path="users")
public interface ChatUserRepository extends JpaRepository<ChatUser, String>, JpaSpecificationExecutor<ChatUser> {
//    ChatUser findByUserId(String userId);

    @Query("select e from ChatUser e where e.userName = ?1")
    Optional<ChatUser> findByUserName(String name);
}