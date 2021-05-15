package com.chemcool.school.chat.service.service;

import com.chemcool.school.chat.service.models.ChatUser;
import java.util.List;

public interface UserService {
    ChatUser addOrUpdateUser(ChatUser user, String roomName);
    ChatUser findByUserName(String name);
    List<ChatUser> findAllUsers();
    void deleteUser(String id);
    void deleteRoom(String id, String roomName);
    List<ChatUser> findAllUsersByRoomId(String id);
}
