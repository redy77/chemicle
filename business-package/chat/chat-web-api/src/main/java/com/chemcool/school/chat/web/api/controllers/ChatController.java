package com.chemcool.school.chat.web.api.controllers;

import com.chemcool.school.chat.service.models.ChatRoom;
import com.chemcool.school.chat.service.models.ChatUser;
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

    @PostMapping("/users")
    public ChatUser addOrUpdateUser(ChatUser user) {
        return chatUserService.addOrUpdateUser(user);
    }

    @DeleteMapping("/users")
    public void deleteUser(String id) {
        chatUserService.deleteUser(id);
    }

    @GetMapping("/rooms")
    public List<ChatRoom> getAllRooms() {
        return chatRoomService.findAllRooms();
    }

    @GetMapping("/rooms/{id}")
    public List<ChatRoom> getAllRoomsByUserId(@PathVariable String id) {
        return chatRoomService.findAllRoomsByUserId(id);
    }

    @PostMapping("/rooms")
    public ChatRoom addRoom(ChatRoom room) {
        return chatRoomService.addRoom(room);
    }

    @DeleteMapping("/rooms/{id}")
    public void deleteRoom(@PathVariable String id) {
        chatRoomService.deleteRoom(id);
    }

}
