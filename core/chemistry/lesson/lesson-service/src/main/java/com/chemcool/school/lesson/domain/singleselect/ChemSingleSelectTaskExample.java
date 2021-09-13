package com.chemcool.school.lesson.domain.singleselect;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChemSingleSelectTaskExample {
    private String taskExampleDescription;
    private String taskExampleCorrectAnswer;
    private Integer taskExampleChapterId;
    private Integer taskExampleReferenceId;
    private String taskExampleIncorrectAnswerOne;
    private String taskExampleIncorrectAnswerTwo;
    private String taskExampleIncorrectAnswerThree;
    private String taskExampleIncorrectAnswerFour;
}
