package com.chemcool.school.tasks.chemequations.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChemEquationsTaskExample {

    private String description; //задание
    private String equations; //уравнение
    private String rightAnswer; //правильный ответ
    private int chapterId; //id главы
    private int referenceId; //id раздела
}
