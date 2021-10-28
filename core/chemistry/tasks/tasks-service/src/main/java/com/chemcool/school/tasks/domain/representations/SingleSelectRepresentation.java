package com.chemcool.school.tasks.domain.representations;

/**
 * @Author Constantine Lee
 */

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class SingleSelectRepresentation {

    private String taskId;

    private String conditionOfTask;

    private String rightAnswer;

    private List<String> answers;

    private Short classNum;

    private Short chapterNum;

    private Short paragraphNum;
}
