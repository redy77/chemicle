package com.chemcool.school.tasks.singleselectquestion.domain;


import com.chemcool.school.tasks.domain.TypeOfTask;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
