package com.chemcool.school.tasks.chemfixedanswer.web.api.dto;

import com.chemcool.school.tasks.chemfixedanswer.domain.ChemistryFixedAnswerTask;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChemistryFixedAnswerTaskDto {
    private String taskId;
    private String description;
    private String rightAnswer;
    private int chapterId;

    public ChemistryFixedAnswerTaskDto(ChemistryFixedAnswerTask task) {
        this.taskId = task.getTaskId();
        this.description = task.getDescription();
        this.rightAnswer = task.getRightAnswer();
        this.chapterId = task.getChapterId();
    }
}
