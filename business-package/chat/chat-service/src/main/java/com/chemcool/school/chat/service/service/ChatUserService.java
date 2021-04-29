package com.chemcool.school.chat.service.service;

import com.chemcool.school.chat.service.models.ChatMessage;
import com.chemcool.school.chat.service.models.ChatRoom;
import com.chemcool.school.chat.service.models.ChatUser;
import com.chemcool.school.chat.service.repository.ChatUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatUserService implements UserService {

    private final ChatUserRepository chatUserRepository;
    private final ChatRoomService chatRoomService;

    @Override
    public List<ChatUser> findAllUsers() {
        return chatUserRepository.findAll();
    }

    @Override
    public void deleteUser(String id) {
        log.info("User: " + id + "  удален.");
        chatUserRepository.deleteById(id);
    }

    @Override
    public ChatUser addOrUpdateUser(ChatUser user) {
        if (user.getId() == null) {
            List<ChatMessage> chatMessage = new ArrayList<>();
            List<ChatRoom> allRoomsByUserId = chatRoomService.findAllRoomsByUserId(user.getId());

            user.setId(UUID.randomUUID().toString());
            user.setChatMessage(chatMessage);
            user.setChatRooms(allRoomsByUserId);
        }
        log.info("Пользователь: " + user.getId() + "  добавлен.");
        return chatUserRepository.save(user);

    }

    @Override
    public ChatUser findByUserName(String name) {
        ChatUser user = null;
        Optional<ChatUser> searchUserResult = chatUserRepository.findByUserName(name);

        if (searchUserResult.isPresent()) {
            user = searchUserResult.get();
        } else {
            throw new RuntimeException("Невозможно найти пользователя по имени: " + name);
        }
        return user;
    }
}
