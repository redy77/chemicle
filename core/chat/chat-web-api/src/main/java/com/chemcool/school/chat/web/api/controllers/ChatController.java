package com.chemcool.school.chat.web.api.controllers;

import com.chemcool.school.chat.service.domain.ChatRoom;
import com.chemcool.school.chat.service.domain.ChatUser;
import com.chemcool.school.chat.service.service.ChatRoomService;
import com.chemcool.school.chat.service.service.ChatUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class ChatController {
    private final ChatUserService chatUserService;
    private final ChatRoomService chatRoomService;

    @GetMapping("/users")
    public List<ChatUser> getAllUsers() {
        return chatUserService.findAllUsers();
    }

    @GetMapping("/room/{id}/users")
    public List<ChatUser> getAllUsersByRoomId(@PathVariable String id) {
        return chatUserService.findAllUsersByRoomId(id);
    }

    @PostMapping("/users")
    public ChatUser addOrUpdateUser(ChatUser user, String roomName) {
        return chatUserService.addOrUpdateUser(user, roomName);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable String id) {
        chatUserService.deleteUser(id);
    }

    @GetMapping("/rooms")
    public List<ChatRoom> getAllRooms() {
        return chatRoomService.findAllRooms();
    }

    @GetMapping("/users/{id}/rooms")
    public List<ChatRoom> getAllRoomsByUserId(@PathVariable String id) {
        return chatRoomService.findAllRoomsByUserId(id);
    }

    @PostMapping("/rooms")
    public ChatRoom addRoom(ChatRoom room) {
        return chatRoomService.addRoom(room);
    }

    @DeleteMapping("/rooms/{id}/{roomName}")
    public void deleteRoom(@PathVariable String id, @PathVariable String roomName) {
        chatUserService.deleteRoom(id, roomName);
    }

}
