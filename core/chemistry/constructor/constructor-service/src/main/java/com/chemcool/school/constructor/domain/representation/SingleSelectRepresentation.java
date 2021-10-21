package com.chemcool.school.constructor.domain.representation;

import com.chemcool.school.constructor.domain.SingleSelectTask;
import com.chemcool.school.tasks.statuses.TaskStatus;
import com.chemcool.school.tasks.statuses.TaskType;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Builder
@Data
public class SingleSelectRepresentation {
    private String conditionOfTask;
    private String rightAnswer;
    private List<String> answers;
    private Short classNum;
    private Short chapterNum;
    private Short paragraphNum;

    public static SingleSelectTask buildTask(SingleSelectRepresentation representation) {
        return SingleSelectTask.builder()
                .taskId(UUID.randomUUID().toString())
                .conditionOfTask(representation.conditionOfTask)
                .classNum(representation.classNum)
                .chapterNum(representation.chapterNum)
                .paragraphNum(representation.paragraphNum)
                .status(TaskStatus.CREATE)
                .type(TaskType.SINGLE_SELECT)
                .isHidden(false)
                .rightAnswer(representation.rightAnswer)
                .answers(representation.answers)
                .build();
    }
}
