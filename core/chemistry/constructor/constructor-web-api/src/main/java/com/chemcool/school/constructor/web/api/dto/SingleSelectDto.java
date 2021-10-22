package com.chemcool.school.constructor.web.api.dto;

/**
 * @Author Constantine Lee
 */

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class SingleSelectDto {

    @NotBlank
    private String conditionOfTask;

    @NotBlank
    private String rightAnswer;

    @NotNull
    private List<String> answers;

    @Range(min = 1, max = 11)
    private Short classNum;

    @Range(min = 1, max = 4)
    private Short chapterNum;

    @Range(min = 1, max = 33)
    private Short paragraphNum;
}
