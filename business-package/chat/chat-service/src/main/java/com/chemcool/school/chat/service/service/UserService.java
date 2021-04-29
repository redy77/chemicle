package com.chemcool.school.chat.service.service;

import com.chemcool.school.chat.service.models.ChatUser;
import java.util.List;

public interface UserService {
    ChatUser addOrUpdateUser(ChatUser user);
    ChatUser findByUserName(String name);
    List<ChatUser> findAllUsers();
    void deleteUser(String id);
}
