package com.chemcool.school.tasks.web.api.domain;

import com.chemcool.school.domain.chemequation.Couple;
import com.chemcool.school.tasks.web.api.dto.TasksDto;
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

    public TaskThree(TasksDto dto) {
        this.id = dto.getId();
        this.description = dto.getDescription();
        this.typeOfTask = dto.getTypeOfTask();
        this.list = dto.getList();
    }

    @Override
    public TypeOfTask getTypeOfTask() {
        return typeOfTask;
    }
}
