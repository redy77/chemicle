package com.chemcool.school.tasks.chemequations.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChemEquationsTaskExample {

    private String description;
    private String rightAnswer;
    private int chapterId;
    private int referenceId;
}
