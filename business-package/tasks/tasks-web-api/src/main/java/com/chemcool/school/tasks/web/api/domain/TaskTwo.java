package com.chemcool.school.tasks.web.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskTwo implements ChemistryTask {
    private UUID id; //Одинаковое поле для всех классов
    private String common; //Одинаковое поле для всех классов
    private TypeOfTask typeOfTask;  //Одинаковое поле для всех классов

    private String two1; //Уникальное поле класса
    private String two2; //Уникальное поле класса

    @Override
    public TypeOfTask getTypeOfTask() {
        return typeOfTask;
    }
}
