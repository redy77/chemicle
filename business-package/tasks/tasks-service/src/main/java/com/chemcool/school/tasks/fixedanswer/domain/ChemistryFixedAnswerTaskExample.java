package com.chemcool.school.tasks.fixedanswer.domain;

import com.chemcool.school.tasks.TypeOfTask;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChemistryFixedAnswerTaskExample {
    private String chemistryFixedAnswerTaskUuid;
    private String description;
    private String rightAnswer;
    private String chapterId;
    private TypeOfTask typeOfTask;
}
