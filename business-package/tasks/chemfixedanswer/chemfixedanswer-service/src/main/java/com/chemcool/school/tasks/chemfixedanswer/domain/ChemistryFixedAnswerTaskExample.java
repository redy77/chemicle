package com.chemcool.school.tasks.chemfixedanswer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChemistryFixedAnswerTaskExample {

    private String description;
    private String rightAnswer;
    private int chapterId;
}
