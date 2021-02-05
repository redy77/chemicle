package com.chemcool.school.chemmatches.domain;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
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
public class ChemistryMatchingTaskEvent {

    @Id
    private String chemistryMatchingTaskEventId;
    private String chemistryMatchingTaskEventAuthorId;
    private String chemistryMatchingTaskEventOccurringContext;
    private LocalDateTime chemistryMatchingTaskEventOccurringContextTime;
    private String chemistryMatchingTaskEventType;
    private String version;
    private String chemistryMatchingTaskEventEntityId;

    @Type(type = "jsonb")
    @Column(name = "chemistry_matching_task_event_payload", columnDefinition = "jsonb")
    private ChemistryMatchingTask chemistryMatchingTaskEventPayload;


    public static ChemistryMatchingTaskEvent createEvent(ChemistryMatchingTask task, String authorId, ChemistryMatchingTaskEventType type){
        return new ChemistryMatchingTaskEvent(
                UUID.randomUUID().toString(),
                authorId,
                "ChemistryMatchingTaskEvent",
                LocalDateTime.now(),
                type.toString(),
                "1.0",
                task.getTaskId(),
                task
        );
    }

}
