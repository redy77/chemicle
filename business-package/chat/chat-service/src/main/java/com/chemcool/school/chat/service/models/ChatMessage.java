package com.chemcool.school.chat.service.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "messages")
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @ManyToOne
    @JoinColumn(name="sender_id")
    private ChatUser user;

    @Column(name = "room_id")
    private String roomId;

    @Column(name = "sender_name")
    private String senderName;

    @Column(name = "message")
    private String message;

    @Column(name = "published_date")
    private Timestamp timestamp;
}
