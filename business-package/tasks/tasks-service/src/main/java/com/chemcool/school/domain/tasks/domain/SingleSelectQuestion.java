package com.chemcool.school.domain.tasks.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Класс выбора фиксированного ответа.
 * Один правильный ответ, три неправильных. *
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SingleSelectQuestion {
    /** Не гаррантирует уникального id, если база будет создана вручную */
    @Id
    @Column(unique=true)
    private String uuid;

    @Column(length = 5000)
    private String description;

    private String rightAnswer;

    private String ChapterId;

    @Enumerated(EnumType.STRING)
    private TypeOfTask typeOfTask;

    private String incorrectAnswer1;
    private String incorrectAnswer2;
    private String incorrectAnswer3;



}
