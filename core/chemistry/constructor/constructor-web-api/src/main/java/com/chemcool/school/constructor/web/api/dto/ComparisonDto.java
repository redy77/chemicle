package com.chemcool.school.constructor.web.api.dto;

import com.chemcool.school.constructor.presentation.ComparisonPresentation;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;

@Data
@NoArgsConstructor
public class ComparisonDto {

    @NotNull
    @JsonProperty("conditionOfTask")
    private String conditionOfTask;

    @NotNull
    @JsonProperty("classNum")
    private Short classNum;

    @NotNull
    @JsonProperty("chapterNum")
    private Short chapterNum;

    @NotNull
    @JsonProperty("paragraphNum")
    private Short paragraphNum;

    @NotNull
    @JsonProperty("keys")
    private List<String> keys;

    @NotNull
    @JsonProperty("values")
    private List<String> values;

    @NotNull
    @JsonProperty("mapping")
    private HashMap<String, String> mapping;

    public ComparisonPresentation toPresentation() {
        ComparisonPresentation comparisonPresentation = new ComparisonPresentation();

        comparisonPresentation.setConditionOfTask(conditionOfTask);
        comparisonPresentation.setClassNum(classNum);
        comparisonPresentation.setChapterNum(chapterNum);
        comparisonPresentation.setParagraphNum(paragraphNum);
        comparisonPresentation.setKeys(keys);
        comparisonPresentation.setValues(values);
        comparisonPresentation.setMapping(mapping);

        return comparisonPresentation;
    }
}
