package com.chemcool.school.chat.service.repository;

import com.chemcool.school.chat.service.models.ChatUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChatUserRepository extends JpaRepository<ChatUser, String>, JpaSpecificationExecutor<ChatUser> {
    Optional<ChatUser> findByUserId(int userId);
}
