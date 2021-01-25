package com.chemcool.school.tasks.chemfixedanswer.web.api.dto;

import com.chemcool.school.tasks.chemfixedanswer.TypeOfTask;
import com.chemcool.school.tasks.chemfixedanswer.domain.ChemistryFixedAnswerTask;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChemistryFixedAnswerTaskDto {
    private String chemistryFixedAnswerTaskUuid;
    private String description;
    private String rightAnswer;
    private String chapterId;
    private TypeOfTask typeOfTask;

    public ChemistryFixedAnswerTaskDto(ChemistryFixedAnswerTask task) {
        this.chemistryFixedAnswerTaskUuid = task.getChemistryFixedAnswerTaskUuid();
        this.description = task.getDescription();
        this.rightAnswer = task.getRightAnswer();
        this.chapterId = task.getChapterId();
        this.typeOfTask = task.getTypeOfTask();
    }
}
