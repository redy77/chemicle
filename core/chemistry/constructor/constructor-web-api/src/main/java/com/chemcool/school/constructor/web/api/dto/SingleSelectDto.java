package com.chemcool.school.constructor.web.api.dto;

import com.chemcool.school.constructor.domain.SingleSelectTask;
import com.chemcool.school.tasks.statuses.TaskStatus;
import com.chemcool.school.tasks.statuses.TaskType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class SingleSelectDto {
    private String conditionOfTask;
    private String rightAnswer;
    private List<String> answers;
    private Short classNum;
    private Short chapterNum;
    private Short paragraphNum;

    public SingleSelectTask dtoToEntity(SingleSelectDto dto) {
        SingleSelectTask task = new SingleSelectTask();
        task.setConditionOfTask(dto.conditionOfTask);
        task.setRightAnswer(dto.rightAnswer);
        task.setAnswers(dto.answers);
        task.setClassNum(dto.classNum);
        task.setChapterNum(dto.chapterNum);
        task.setParagraphNum(dto.paragraphNum);
        task.setTaskStatus(TaskStatus.CREATE);
        task.setTaskType(TaskType.SINGLE_SELECT);
        task.setIsHidden(false);
        return task;
    }
}
