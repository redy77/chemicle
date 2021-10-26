package com.chemcool.school.tasks.domain;

import com.chemcool.school.tasks.models.Task;
import com.chemcool.school.tasks.statuses.TaskStatus;
import com.chemcool.school.tasks.statuses.TaskType;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @Author : Constantine Lee
 * @Date : 26.10.2021
 * @e-mail : rhowbn@gmail.com
 */
@Data
@Entity
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class TheoryTask extends Task {
    
    @Column(name = "theory_text")
    private String theoryText;

    @Builder
    public TheoryTask(String taskId, String conditionOfTask, Short classNum, Short chapterNum,
                      Short paragraphNum, TaskStatus status, TaskType type, Boolean isHidden,
                      String theoryText) {
        super(taskId, conditionOfTask, classNum, chapterNum, paragraphNum,status, type, isHidden);
        this.theoryText = theoryText;
    }
}
