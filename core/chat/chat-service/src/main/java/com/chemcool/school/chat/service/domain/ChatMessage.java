package com.chemcool.school.chat.service.domain;

import com.chemcool.school.chat.service.miscelaneous.MessageType;
import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "messages")
@TypeDef(
        name = "message_type_enum",
        typeClass = PostgreSQLEnumType.class
)
public class ChatMessage {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name="chat_user")
    private ChatUser user;

    @Column(name = "room_id")
    private String roomId;

    @Column(name = "name")
    private String senderName;

    @Column(name = "sender_id")
    private String senderId;

    @Column(name = "message")
    private String message;

    @Column(name = "published_date")
    private Timestamp timestamp;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "message_type")
    @Type( type = "message_type_enum" )
    private MessageType type;

    @Override
    public String toString() {
        return "ChatMessage{" +
                "id='" + id + '\'' +
                ", roomId='" + roomId + '\'' +
                ", senderName='" + senderName + '\'' +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
