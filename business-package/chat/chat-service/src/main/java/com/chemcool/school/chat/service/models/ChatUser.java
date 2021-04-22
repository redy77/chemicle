package com.chemcool.school.chat.service.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Id
    private String id;

    @Column(name = "name")
    private String userName;

    @Column(name = "role")
    private String userRole;

    @JsonIgnore
    @OneToMany(mappedBy="user", orphanRemoval = true, fetch = FetchType.EAGER )
    private List<ChatMessage> chatMessage = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "users")
    private List<ChatRoom> chatRooms = new ArrayList<>();

    @Override
    public String toString() {
        return "ChatUser{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", userRole='" + userRole + '\'' +
                ", chatMessage=" + chatMessage +
                '}';
    }
}
