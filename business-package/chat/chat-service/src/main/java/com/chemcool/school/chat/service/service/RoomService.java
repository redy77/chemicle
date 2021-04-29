package com.chemcool.school.chat.service.service;

import com.chemcool.school.chat.service.models.ChatRoom;
import java.util.List;

public interface RoomService {
    List<ChatRoom> findAllRooms();
    List<ChatRoom> findAllRoomsByUserId(String id);
    void deleteRoom(String id);
    ChatRoom addRoom(ChatRoom room);
}
