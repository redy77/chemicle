package com.chemcool.school.chat.service.service;

import com.chemcool.school.chat.service.domain.ChatRoom;
import java.util.List;

public interface RoomService {
    List<ChatRoom> findAllRooms();
    List<ChatRoom> findAllRoomsByUserId(String id);
    ChatRoom addRoom(ChatRoom room);
    ChatRoom findByRoomName(String name);
}
