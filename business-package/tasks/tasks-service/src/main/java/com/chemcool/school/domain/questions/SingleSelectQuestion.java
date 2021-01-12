package com.chemcool.school.domain.questions;

import com.chemcool.school.domain.Chapter;
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

    /**
     * Тема:
     * Органические вещества
     * Химические элементы и пр.
     *
     * Выводится в заголовке задачи
     */
    private String theme;

    @Column(length = 5000)
    private String description;

    /**
     * Количество очком в зависимости от сложности 1-4 к примеру
     */
    private int mark;

    private String rightAnswer;
    private String incorrectAnswer1;
    private String incorrectAnswer2;
    private String incorrectAnswer3;

    @Enumerated(EnumType.STRING)
    private Chapter chapter;     // Название раздела, которому принадлежит задача (число, имя, enum)
}
