package com.chemcool.school.tasks.domain.representation;
/**
 * @Author Constantine Lee
 */

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class SingleSelectRepresentation {
    private String conditionOfTask;
    private String rightAnswer;
    private List<String> answers;
    private Short classNum;
    private Short chapterNum;
    private Short paragraphNum;
}
