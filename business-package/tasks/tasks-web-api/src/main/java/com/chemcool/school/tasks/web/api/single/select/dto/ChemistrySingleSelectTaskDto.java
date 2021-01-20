package com.chemcool.school.tasks.web.api.single.select.dto;


import com.chemcool.school.tasks.domain.TypeOfTask;
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
public class ChemistrySingleSelectTaskDto {
    private String chemistrySingleSelectTaskUuid;
    private String description;
    private String rightAnswer;
    private String chapterId;
    private TypeOfTask typeOfTask;
    private String incorrectAnswer1;
    private String incorrectAnswer2;
    private String incorrectAnswer3;

    public ChemistrySingleSelectTaskDto(ChemistrySingleSelectTask task) {
        this.chemistrySingleSelectTaskUuid = task.getChemistrySingleSelectTaskUuid();
        this.description = task.getDescription();
        this.rightAnswer = task.getRightAnswer();
        this.chapterId = task.getChapterId();
        this.typeOfTask = task.getTypeOfTask();
        this.incorrectAnswer1 = task.getIncorrectAnswer1();
        this.incorrectAnswer2 = task.getIncorrectAnswer2();
        this.incorrectAnswer3 = task.getIncorrectAnswer3();
    }
}
