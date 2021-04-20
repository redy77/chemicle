package com.chemcool.school.chat.service.models;

import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "messages")
@TypeDef(
        name = "pgsql_enum",
        typeClass = PostgreSQLEnumType.class
)
public class ChatMessage {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "message_type")
    @Type( type = "pgsql_enum" )
    private MessageType type;

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE;
    }

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
