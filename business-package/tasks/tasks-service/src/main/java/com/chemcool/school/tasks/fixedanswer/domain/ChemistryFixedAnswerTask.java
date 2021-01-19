package com.chemcool.school.tasks.fixedanswer.domain;

import com.chemcool.school.tasks.domain.ChemistryTask;
import com.chemcool.school.tasks.domain.TypeOfTask;
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
public class ChemistryFixedAnswerTask implements ChemistryTask {

    @Id
    @Column(name = "chemistry_fixed_answer_task_uuid")
    private String chemistryFixedAnswerTaskUuid;

    @Column(name = "description", length = 5000)
    private String description;

    @Column(name = "right_answer")
    @NonNull
    private String rightAnswer;

    @Column(name = "chapter_id")
    @NonNull
    private String chapterId;

    @Column(name = "type_of_task")
    @Enumerated(EnumType.STRING)
    @NonNull
    private TypeOfTask typeOfTask;

    public static ChemistryFixedAnswerTask createChemistryFixedAnswerTask(
            ChemistryFixedAnswerTaskExample task
    ){
        return new ChemistryFixedAnswerTask(
                UUID.randomUUID().toString(),
                task.getDescription(),
                task.getRightAnswer(),
                task.getChapterId(),
                task.getTypeOfTask()
        );
    }
}
