package com.chemcool.school.tasks.domain;
/**
 * @Author Constantine Lee
 */

import com.chemcool.school.tasks.models.Task;
import com.chemcool.school.tasks.statuses.TaskStatus;
import com.chemcool.school.tasks.statuses.TaskType;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SingleSelectTask extends Task {

    @Column(name = "right_answer")
    private String rightAnswer;

    @ElementCollection(fetch = FetchType.LAZY)
    private List<String> answers = new ArrayList<>();

    @Builder
    public SingleSelectTask(String taskId, String conditionOfTask, Short classNum, Short chapterNum,
                            Short paragraphNum, TaskStatus status, TaskType type, Boolean isHidden,
                            String rightAnswer, List<String> answers) {
        super(taskId, conditionOfTask, classNum, chapterNum, paragraphNum,status, type, isHidden);
        this.rightAnswer = rightAnswer;
        this.answers = answers;
    }

}
