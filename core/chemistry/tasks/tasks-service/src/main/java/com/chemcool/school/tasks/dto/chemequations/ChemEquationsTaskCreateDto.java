package com.chemcool.school.tasks.dto.chemequations;

import com.chemcool.school.tasks.domain.chemequations.ChemEquationsTask;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChemEquationsTaskCreateDto {
    private String taskId;
    private String description;
    private String rightAnswer;
    private int chapterId;
    private int referenceId;

    public ChemEquationsTaskCreateDto(ChemEquationsTask task) {
        this.taskId = task.getTaskId();
        this.description = task.getDescription();
        this.rightAnswer = task.getRightAnswer();
        this.chapterId = task.getChapterId();
        this.referenceId = task.getReferenceId();
    }
}
