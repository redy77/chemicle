package com.chemcool.school.tasks.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Класс выбора фиксированного ответа.
 * Один правильный ответ, три неправильных. *
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChemistrySingleSelectTaskExample {
    private String chemistrySingleSelectTaskUuid;
    private String description;
    private String rightAnswer;
    private String chapterId;
    private TypeOfTask typeOfTask;
    private String incorrectAnswer1;
    private String incorrectAnswer2;
    private String incorrectAnswer3;
}
