package com.chemcool.school.tasks.chemfixedanswer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fixed_answer")
public class ChemistryFixedAnswerTask {

    @Id
    @Column(name = "task_id")
    private String taskId;

    @Column(name = "description", length = 10000)
    private String description;

    @Column(name = "right_answer")
    @NonNull
    private String rightAnswer;

    @Column(name = "chapter_id")
    @NonNull
    private int chapterId;

    public static ChemistryFixedAnswerTask createChemistryFixedAnswerTask(
            ChemistryFixedAnswerTaskExample task
    ){
        return new ChemistryFixedAnswerTask(
                UUID.randomUUID().toString(),
                task.getDescription(),
                task.getRightAnswer(),
                task.getChapterId()
        );
    }
}
