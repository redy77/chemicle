package com.chemcool.school.tasks.domain.representations;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class FixedAnswerRepresentation implements TaskRepresentation{

    private String taskId;

    private String conditionOfTask;

    private Short classNum;

    private Short chapterNum;

    private Short paragraphNum;

    private String answer;
}
