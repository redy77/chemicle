package com.chemcool.school.lesson.tasks.chemequations.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChemEquationsTaskExample extends ChemEquationsTask{

    private String description;
    private String rightAnswer;

    private int chapterId;
    private int referenceId;
}