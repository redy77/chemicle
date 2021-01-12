package com.chemcool.school.tasks.web.api.dto;

import com.chemcool.school.domain.chemequation.Couple;
import com.chemcool.school.tasks.web.api.domain.ChemistryTask;
import com.chemcool.school.tasks.web.api.domain.TaskOne;
import com.chemcool.school.tasks.web.api.domain.TaskTwo;
import com.chemcool.school.tasks.web.api.domain.TypeOfTask;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class TasksDto implements ChemistryTask {
    private UUID id; //Одинаковое поле для всех классов
    private String description; //Одинаковое поле для всех классов
    private TypeOfTask typeOfTask;  //Одинаковое поле для всех классов

    private String one; //Уникальное поле класса 1

    private String two1; //Уникальное поле класса 2
    private String two2; //Уникальное поле класса 2

    private List<Couple> list; //Уникальное поле класса 3

    public TasksDto(UUID id, String description, TypeOfTask typeOfTask) {
        this.id = id;
        this.description = description;
        this.typeOfTask = typeOfTask;
    }

    public TasksDto(TaskOne task) {
        this(task.getId(), task.getDescription(), task.getTypeOfTask());
        this.one = task.getOne();
    }

    public TasksDto(TaskTwo task) {
        this(task.getId(), task.getDescription(), task.getTypeOfTask());
        this.two1 = task.getTwo1();
        this.two2 = task.getTwo2();
    }

    @Override
    public TypeOfTask getTypeOfTask() {
        return typeOfTask;
    }
}
