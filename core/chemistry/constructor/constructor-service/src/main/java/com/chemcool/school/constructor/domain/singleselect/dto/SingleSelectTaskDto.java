package com.chemcool.school.constructor.domain.singleselect.dto;

import com.chemcool.school.constructor.domain.singleselect.entities.SingleSelectCon;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SingleSelectTaskDto {
    private Long id;
    private String conditionOfTask;
    private String rightAnswer;
    private String answersArray;
    private int classNum;
    private int chapterNum;
    private int paragraphNum;
    private String taskStatus;
    private boolean isHiden;

    public SingleSelectTaskDto(SingleSelectCon task) {
        this.id = task.getId();
        this.conditionOfTask = task.getConditionOfTask();
        this.rightAnswer = task.getRightAnswer();
        this.answersArray = task.getAnswersArray();
        this.classNum = task.getClassNum();
        this.chapterNum = task.getChapterNum();
        this.paragraphNum = task.getParagraphNum();
        this.taskStatus = task.getTaskStatus();
        this.isHiden = task.isHiden();
    }
}
