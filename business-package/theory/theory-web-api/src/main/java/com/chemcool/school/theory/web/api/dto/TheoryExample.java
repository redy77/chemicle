package com.chemcool.school.theory.web.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TheoryExample {
    private String theoryExampleName;
    private String theoryExampleDescription;
    private Integer theoryExampleChapter;
    private Integer theoryExampleReferences;
}
