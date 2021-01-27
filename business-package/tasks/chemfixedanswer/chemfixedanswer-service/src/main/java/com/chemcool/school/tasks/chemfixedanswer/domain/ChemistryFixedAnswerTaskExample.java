package com.chemcool.school.tasks.chemfixedanswer.domain;

import com.chemcool.school.tasks.chemfixedanswer.TypeOfTask;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChemistryFixedAnswerTaskExample {

    private String description;
    private String rightAnswer;
    private String chapterId;
    private TypeOfTask typeOfTask;
}
