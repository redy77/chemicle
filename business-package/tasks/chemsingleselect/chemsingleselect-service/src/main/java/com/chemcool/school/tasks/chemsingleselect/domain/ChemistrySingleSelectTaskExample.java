package com.chemcool.school.tasks.chemsingleselect.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChemistrySingleSelectTaskExample {
    private String descriptionExample;
    private String rightAnswerExample;
    private String chapterIdExample;
    private TypeOfTask typeOfTaskExample;
    private String incorrectAnswer1Example;
    private String incorrectAnswer2Example;
    private String incorrectAnswer3Example;
}
