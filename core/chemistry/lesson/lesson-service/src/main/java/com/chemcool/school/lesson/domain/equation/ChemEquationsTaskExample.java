package com.chemcool.school.lesson.domain.equation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChemEquationsTaskExample extends ChemEquationsTask {

    private String description;
    private String rightAnswer;

    private Integer chapterId;
    private Integer referenceId;
}