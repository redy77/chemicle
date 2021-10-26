package com.chemcool.school.theory.domain;

import com.chemcool.school.tasks.models.Task;
import com.chemcool.school.tasks.statuses.TaskStatus;
import com.chemcool.school.tasks.statuses.TaskType;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Table;


@Data
@NoArgsConstructor
@Entity
@Table(name ="сhemistru_fixed_create_task" )
public class FixedAnswerTask extends Task {

    @NonNull
    private String answer;

    @Builder
    public FixedAnswerTask(String taskId, String conditionOfTask, Short classNum,
                           Short chapterNum, Short paragraphNum, TaskStatus taskStatus,
                           TaskType taskType, Boolean isHidden, String answer) {
        super(taskId, conditionOfTask, classNum, chapterNum, paragraphNum, taskStatus, taskType, isHidden);
        this.answer = answer;
    }
}
