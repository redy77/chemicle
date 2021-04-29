package com.chemcool.school.chat.service.service;

import com.chemcool.school.chat.service.models.ChatRoom;
import com.chemcool.school.chat.service.models.ChatUser;
import com.chemcool.school.chat.service.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatRoomService implements RoomService {
    private final ChatRoomRepository chatRoomRepository;

    @Override
    public List<ChatRoom> findAllRooms() {
        return chatRoomRepository.findAll();
    }

    @Override
    public List<ChatRoom> findAllRoomsByUserId(String id) {
        return chatRoomRepository.findAllRoomsByUserId(id);
    }

    @Override
    public void deleteRoom(String id) {
        log.info("Чат-комната: " + id + "  удалена.");
        chatRoomRepository.deleteById(id);
    }

    @Override
    public ChatRoom addRoom(ChatRoom room) {
        List<ChatUser> users = new ArrayList<>();
        room.setId(UUID.randomUUID().toString());
        room.setUsers(users);
        log.info("Чат-комната: " + room.getId() + "  добавлена.");
        return chatRoomRepository.save(room);
    }
}
