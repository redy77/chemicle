package com.chemcool.school.constructor.web.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class ComparisonDto {

    @NotNull
    @JsonProperty("title")
    private String title;

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
    private Map<String, String> mapping;
}
