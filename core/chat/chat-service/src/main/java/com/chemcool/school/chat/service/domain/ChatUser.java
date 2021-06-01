package com.chemcool.school.chat.service.domain;

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
    private String name;

    @Column(name = "role")
    private String userRole;

    @JsonIgnore
    @OneToMany(mappedBy="user", orphanRemoval = true, fetch = FetchType.EAGER )
    private List<ChatMessage> chatMessage = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "users", cascade = CascadeType.MERGE)
    private List<ChatRoom> chatRooms = new ArrayList<>();

    @Override
    public String toString() {
        return "ChatUser{" +
                "id='" + id + '\'' +
                ", userName='" + name + '\'' +
                ", userRole='" + userRole + '\'' +
                ", chatMessage=" + chatMessage +
                '}';
    }
}
