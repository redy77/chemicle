package com.chemcool.school.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskOne implements ChemistryTask {
    private UUID id; //Одинаковое поле для всех классов
    private String common; //Одинаковое поле для всех классов
    private TypeOfTask typeOfTask;  //Одинаковое поле для всех классов

    private String one; //Уникальное поле класса

    public TypeOfTask getTypeOfTask() {
        return typeOfTask;
    }
}
