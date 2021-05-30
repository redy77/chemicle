package com.chemcool.school.chat.service.domain;

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
@Table(name = "rooms")
public class ChatRoom {

    @Id
    private String id;

    @Column(name = "name")
    private String roomName;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_linked_rooms",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<ChatUser> users = new ArrayList<>();

}
