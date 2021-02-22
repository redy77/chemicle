package com.chemcool.school.tasks.chemequations.web.api.dto;

import com.chemcool.school.tasks.chemequations.domain.ChemEquationsTask;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChemEquationsTaskDto {
    private String taskId;
    private String description;
    private String equations;
    private String rightAnswer;
    private int chapterId;
    private int referenceId;

    public ChemEquationsTaskDto(ChemEquationsTask task) {
        this.taskId = task.getTaskId();
        this.description = task.getDescription();
        this.equations = task.getEquations();
        this.rightAnswer = task.getRightAnswer();
        this.chapterId = task.getChapterId();
        this.referenceId = task.getReferenceId();
    }
}
