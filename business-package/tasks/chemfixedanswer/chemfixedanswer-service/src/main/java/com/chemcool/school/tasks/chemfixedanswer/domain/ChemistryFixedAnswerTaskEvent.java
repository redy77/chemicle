package com.chemcool.school.tasks.chemfixedanswer.domain;

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
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@TypeDefs(
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
)
public class ChemistryFixedAnswerTaskEvent {

    @Id
    @Column(name = "chem_fixed_answer_task_event_id")
    private String chemFixedAnswerTaskEventId;

    @Column(name = "chem_fixed_answer_task_event_author_id")
    private String chemFixedAnswerTaskEventAuthorId;

    @Column(name = "chem_fixed_answer_task_event_occuring_comtext")
    private String chemFixedAnswerTaskEventOccuringContext;

    @Column(name = "chem_fixed_answer_task_event_occuring_context_time")
    private LocalDateTime chemFixedAnswerTaskEventOccuringContextTime;

    @Column(name = "chem_fixed_answer_task_event_type")
    private ChemistryFixedAnswerTaskEventType chemFixedAnswerTaskEventType;

    @Column(name = "chem_fixed_answer_task_event_version")
    private String chemFixedAnswerTaskEventVersion;

    @Column(name = "chem_fixed_answer_task_event_entity_id")
    private String chemFixedAnswerTaskEventEntityId;

    @Type(type = "jsonb")
    @Column(name = "chem_fixed_answer_task_event_payload", columnDefinition = "jsonb")
    private ChemistryFixedAnswerTask chemFixedAnswerTaskEventPayload;

    public static ChemistryFixedAnswerTaskEvent createEvent(ChemistryFixedAnswerTaskExample example){
        ChemistryFixedAnswerTask lesson = ChemistryFixedAnswerTask.createChemistryFixedAnswerTask(example);
        return new ChemistryFixedAnswerTaskEvent(
                UUID.randomUUID().toString(),
                "777",
                "ChemistryFixedAnswerTaskEvent",
                LocalDateTime.now(),
                ChemistryFixedAnswerTaskEventType.CREATE,
                "1.0",
                lesson.getTaskId(),
                lesson
        );
    }
}
