package com.chemcool.school.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskThree implements ChemistryTask {
    private UUID id; //Одинаковое поле для всех классов
    private String description; //Одинаковое поле для всех классов
    private TypeOfTask typeOfTask;  //Одинаковое поле для всех классов

    private List<Couple> list; //Уникальное поле класса 3

    @Override
    public TypeOfTask getTypeOfTask() {
        return typeOfTask;
    }
}
