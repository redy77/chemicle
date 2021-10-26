package com.chemcool.school.constructor.web.api.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

/**
 * @Author : Constantine Lee
 * @Date : 26.10.2021
 * @e-mail : rhowbn@gmail.com
 */
@Data
public class TheoryTaskDto {
    @NotBlank
    private String conditionOfTask;

    @Range(min = 1, max = 11, message = "classNum must be in range between 1 and 11")
    private Short classNum;


    @Range(min = 1, max = 4, message = "chapterNum must be in range between 1 and 4")
    private Short chapterNum;

    @Range(min = 1, max = 100, message = "paragraphNum must be in range between 1 and 100")
    private Short paragraphNum;

    @NotBlank
    private String theoryText;
}
