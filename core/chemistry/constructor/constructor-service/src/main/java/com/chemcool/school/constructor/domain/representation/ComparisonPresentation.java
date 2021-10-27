package com.chemcool.school.constructor.domain.representation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@Builder
@AllArgsConstructor
public class ComparisonPresentation {

    private String conditionOfTask;
    private Short classNum;
    private Short chapterNum;
    private Short paragraphNum;
    private HashMap<String, String> correctAnswers;
}
