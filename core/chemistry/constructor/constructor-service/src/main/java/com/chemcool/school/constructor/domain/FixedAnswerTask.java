package com.chemcool.school.constructor.domain;

import com.chemcool.school.tasks.models.Task;
import com.chemcool.school.tasks.statuses.TaskStatus;
import com.chemcool.school.tasks.statuses.TaskType;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Data
@NoArgsConstructor
@Entity
@Table(name ="сhemistru_fixed_create_task" )
public class FixedAnswerTask extends Task {

    @NotBlank
    private String idAuthor;

    @NotBlank
    private String answer;

    @Builder
    public FixedAnswerTask(String taskId, String conditionOfTask, Short classNum,
                           Short chapterNum, Short paragraphNum, TaskStatus taskStatus,
                           TaskType taskType, Boolean isHidden, String idAuthor, String answer) {
        super(taskId, conditionOfTask, classNum, chapterNum, paragraphNum, taskStatus, taskType, isHidden);
        this.idAuthor = idAuthor;
        this.answer = answer;
    }


}
