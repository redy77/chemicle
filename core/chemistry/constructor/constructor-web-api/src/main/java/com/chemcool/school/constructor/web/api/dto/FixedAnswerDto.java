package com.chemcool.school.constructor.web.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class FixedAnswerDto {

    @NotBlank
    private String conditionOfTask;

    @Range(min = 1, max = 11, message = "classNum must be in range between 1 and 11")
    private Short classNum;


    @Range(min = 1, max = 4, message = "chapterNum must be in range between 1 and 4")
    private Short chapterNum;

    @NotBlank
    private Short paragraphNum;

    @NotBlank
    private String answer;

    @NotBlank
    private String idAuthor;


}
