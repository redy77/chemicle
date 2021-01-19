package com.chemcool.school.tasks.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

/**
 * Класс выбора фиксированного ответа.
 * Один правильный ответ, три неправильных. *
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ChemistrySingleSelectTask {
    /** Не гаррантирует уникального id, если база будет создана вручную */
    @Id
    @Column(unique=true, name = "chemistry_single_select_task_uuid")
    private String chemistrySingleSelectTaskUuid;

    @Column(length = 5000)
    private String description;

    private String rightAnswer;

    private String chapterId;

    @Enumerated(EnumType.STRING)
    private TypeOfTask typeOfTask;

    private String incorrectAnswer1;
    private String incorrectAnswer2;
    private String incorrectAnswer3;

    public static ChemistrySingleSelectTask createChemistrySingleSelectTask(
            ChemistrySingleSelectTaskExample example
    ) {
        return new ChemistrySingleSelectTask(
                UUID.randomUUID().toString(),
                example.getDescription(),
                example.getRightAnswer(),
                example.getChapterId(),
                example.getTypeOfTask(),
                example.getIncorrectAnswer1(),
                example.getIncorrectAnswer2(),
                example.getIncorrectAnswer3()
        );
    }

}
