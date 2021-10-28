package com.chemcool.school.tasks.web.api.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class FixedAnswerDto {

    private String taskId;

    @NotBlank
    private String conditionOfTask;

    @Range(min = 1, max = 11, message = "класс (от 1 до 11)")
    private Short classNum;


    @Range(min = 1, max = 4, message = "глава (от 1 до 4)")
    private Short chapterNum;

    @Range(min = 1, max = 100, message = "параграф (от 1 до 100)")
    private Short paragraphNum;

    @NotBlank
    private String answer;
}
