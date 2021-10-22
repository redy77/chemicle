package com.chemcool.school.constructor.web.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.util.HashMap;

@Data
@NoArgsConstructor
public class ComparisonDto {

    @NotNull
    @JsonProperty("conditionOfTask")
    private String conditionOfTask;

    @NotNull
    @Range(min = 1, max = 11, message = "classNum must be in range between 1 and 11")
    @JsonProperty("classNum")
    private Short classNum;

    @NotNull
    @Range(min = 1, max = 4, message = "classNum must be in range between 1 and 4")
    @JsonProperty("chapterNum")
    private Short chapterNum;

    @NotNull
    @Range(min = 1, max = 100, message = "classNum must be in range between 1 and 100")
    @JsonProperty("paragraphNum")
    private Short paragraphNum;


    @NotNull
    @JsonProperty("correctAnswers")
    private HashMap<String, String> correctAnswers;
}
