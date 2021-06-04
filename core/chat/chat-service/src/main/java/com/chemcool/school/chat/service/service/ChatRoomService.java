package com.chemcool.school.chat.service.service;

import com.chemcool.school.chat.service.domain.ChatRoom;
import com.chemcool.school.chat.service.domain.ChatUser;
import com.chemcool.school.chat.service.repository.ChatRoomRepository;
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
    public ChatRoom addRoom(ChatRoom room) {
        if (room.getId() == null || room.getId().isEmpty()) {
            List<ChatUser> users = new ArrayList<>();
            String trimmedRoomName = room.getRoomName().trim();
            room.setRoomName(trimmedRoomName);
            room.setId(UUID.randomUUID().toString());
            room.setUsers(users);
            log.info("Чат-комната: " + room.getId() + "  добавлена.");
        } else {
            log.info("Чат-комната: " + room.getId() + "  обновлена.");
        }
        ChatRoom savedRoom = chatRoomRepository.save(room);
        return savedRoom;
    }

    @Override
    public ChatRoom findByRoomName(String name) {
        ChatRoom room = null;
        Optional<ChatRoom> searchRoomResult = chatRoomRepository.findByRoomName(name.trim());

        if (searchRoomResult.isPresent()) {
            room = searchRoomResult.get();
        } else {
            throw new RuntimeException("Невозможно найти чат-комнату по имени: " + name);
        }
        return room;
    }
}
