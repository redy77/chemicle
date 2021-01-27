package com.chemcool.school.theory.domain;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@TypeDefs(
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
)
public class ChemistryLessonEvent {
    @Id
    @Column(name = "event_id")
    private String eventId;

    @Column(name = "event_author_id")
    private String eventAuthorId;

    @Column(name = "event_occurring_context")
    private String eventOccurringContext;

    @Column(name = "event_occurring_context_time")
    private LocalDateTime eventOccurringContextTime;

    private ChemistryLessonEventType eventType;

    private String version;

    private String EventEntityId;


    @Type(type = "jsonb")
    @Column(name = "event_payload", columnDefinition = "jsonb")
    private ChemistryLesson event_payload;

    private static ChemistryLessonEvent createEvent(ChemistryLessonExample lessonExample) {
        ChemistryLesson lesson = ChemistryLessonFactory.createLesson(lessonExample);
        return new ChemistryLessonEvent(
                UUID.randomUUID().toString(),
                "123",
                "ChemistryLessonEvent",
                LocalDateTime.now(),
                ChemistryLessonEventType.CREATED,
                "1.0",
                lesson.getLessonId(),
                lesson
        );
    }
}
