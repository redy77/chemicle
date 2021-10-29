package com.chemcool.school.tasks.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;

@Data
@Builder
public class ComparisonDTO implements TaskDTO {

    private String taskId;

    private String conditionOfTask;

    private Short classNum;

    private Short chapterNum;

    private Short paragraphNum;

    private HashMap<String, String> correctAnswers;
}
