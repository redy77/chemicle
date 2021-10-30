package com.chemcool.school.tasks.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SingleSelectDTO implements TaskDTO {

    private String taskId;

    private String conditionOfTask;

    private String rightAnswer;

    private List<String> answers;

    private Short classNum;

    private Short chapterNum;

    private Short paragraphNum;
}
