package com.chemcool.school.tasks.domain.representations;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor
public class ComparisonRepresentation implements TaskRepresentation{

    private String taskId;

    private String conditionOfTask;

    private Short classNum;

    private Short chapterNum;

    private Short paragraphNum;

    private HashMap<String, String> correctAnswers;
}
