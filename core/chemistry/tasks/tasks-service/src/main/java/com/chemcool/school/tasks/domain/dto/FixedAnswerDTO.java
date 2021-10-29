package com.chemcool.school.tasks.domain.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class FixedAnswerDTO implements TaskDTO {

    private String taskId;

    private String conditionOfTask;

    private Short classNum;

    private Short chapterNum;

    private Short paragraphNum;

    private String answer;
}
