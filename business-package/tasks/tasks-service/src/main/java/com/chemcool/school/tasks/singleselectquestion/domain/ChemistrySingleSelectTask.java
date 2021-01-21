package com.chemcool.school.tasks.singleselectquestion.domain;


import com.chemcool.school.tasks.domain.ChemistryTask;
import com.chemcool.school.tasks.domain.TypeOfTask;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

/**
 * Класс вопрос с одним выбором ответа.
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
                example.getDescriptionExample(),
                example.getRightAnswerExample(),
                example.getChapterIdExample(),
                example.getTypeOfTaskExample(),
                example.getIncorrectAnswer1Example(),
                example.getIncorrectAnswer2Example(),
                example.getIncorrectAnswer3Example()
        );
    }
}
