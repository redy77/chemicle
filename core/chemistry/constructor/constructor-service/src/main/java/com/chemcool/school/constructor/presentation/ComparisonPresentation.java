package com.chemcool.school.constructor.presentation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

@Data
@NoArgsConstructor
public class ComparisonPresentation {

    private String conditionOfTask;
    private Short classNum;
    private Short chapterNum;
    private Short paragraphNum;
    private List<String> keys;
    private List<String> values;
    private HashMap<String, String> mapping;
}
