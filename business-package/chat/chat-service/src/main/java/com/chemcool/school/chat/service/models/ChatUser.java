package com.chemcool.school.chat.service.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class ChatUser {

    public ChatUser(String id, String userName, String userRole) {
        this.id = id;
        this.userName = userName;
        this.userRole = userRole;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "name")
    private String userName;

    @Column(name = "role")
    private String userRole;

    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private List<ChatRoom> chatRooms = new ArrayList<>();

    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<ChatMessage> chatMessage = new ArrayList<>();

}
