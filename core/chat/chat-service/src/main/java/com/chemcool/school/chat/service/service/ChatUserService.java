package com.chemcool.school.chat.service.service;

import com.chemcool.school.chat.service.domain.ChatMessage;
import com.chemcool.school.chat.service.domain.ChatRoom;
import com.chemcool.school.chat.service.domain.ChatUser;
import com.chemcool.school.chat.service.repository.ChatRoomRepository;
import com.chemcool.school.chat.service.repository.ChatUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatUserService implements UserService {

    private final ChatUserRepository chatUserRepository;
    private final ChatRoomRepository chatRoomRepository;
    private final ChatRoomService chatRoomService;

    @Override
    public List<ChatUser> findAllUsers() {
        return chatUserRepository.findAll();
    }

    @Override
    public void deleteUser(String id) {
        List<ChatRoom> foundRoomsByUserId = chatRoomService.findAllRoomsByUserId(id);

        for (ChatRoom room : foundRoomsByUserId) {
            List<ChatUser> updatedUsers = room.getUsers().stream().filter(user -> !user.getId().equals(id)).collect(Collectors.toList());
            room.setUsers(updatedUsers);
            chatRoomService.addRoom(room);
        }

        log.info("User: " + id + "  удален.");
        chatUserRepository.deleteById(id);
    }

    @Override
    public void deleteRoom(String id, String roomName) {
        List<ChatUser> foundUsersByRoomId = findAllUsersByRoomId(id);

        for (ChatUser user : foundUsersByRoomId) {
            List<ChatRoom> updatedRooms = user.getChatRooms().stream().filter(room -> !room.getId().equals(id)).collect(Collectors.toList());
            user.setChatRooms(updatedRooms);
            addOrUpdateUser(user, roomName);
        }

        log.info("Чат-комната: " + id + "  удалена.");
        chatRoomRepository.deleteById(id);
    }

    @Override
    public ChatUser addOrUpdateUser(ChatUser user, String roomName) {
        ChatRoom foundRoomByRoomName = chatRoomService.findByRoomName(roomName);

        if (user.getId() == null || user.getId().isEmpty()) {
            List<ChatMessage> chatMessage = new ArrayList<>();
            List<ChatRoom> chatRooms = new ArrayList<>();
            chatRooms.add(foundRoomByRoomName);

            user.setChatRooms(chatRooms);
            user.setId(UUID.randomUUID().toString());
            user.setChatMessage(chatMessage);

        } else {
            List<ChatRoom> chatRooms = user.getChatRooms();
            chatRooms.add(foundRoomByRoomName);
            user.setChatRooms(chatRooms);
        }
        return getChatUser(user, foundRoomByRoomName);
    }

    private ChatUser getChatUser(ChatUser user, ChatRoom foundRoomByRoomName) {
        ChatUser savedUser = chatUserRepository.save(user);
        log.info("Пользователь: " + savedUser.getId() + "  обновлен или добавлен.");

        List<ChatUser> usersInRoom = foundRoomByRoomName.getUsers();
        boolean userExistsInRoomUsersList = usersInRoom.stream().anyMatch(u -> u.getId().equals(user.getId()));

        if (!userExistsInRoomUsersList) {
            usersInRoom.add(user);
            foundRoomByRoomName.setUsers(usersInRoom);
            chatRoomService.addRoom(foundRoomByRoomName);
            log.info("Данный пользователь добавлен в список пользователей данной чат-комнаты");
        }

        return savedUser;
    }

    @Override
    public List<ChatUser> findAllUsersByRoomId(String id) {

        List<ChatUser> usersList = new ArrayList<>();
        Optional<List<ChatUser>> searchUserResult = chatUserRepository.findAllUsersByRoomId(id);

        if (searchUserResult.isPresent()) {
            usersList = searchUserResult.get();
        }
        return usersList;
    }
}
