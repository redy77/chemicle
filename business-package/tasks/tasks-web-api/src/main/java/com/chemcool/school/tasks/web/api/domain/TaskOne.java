package com.chemcool.school.tasks.web.api.domain;

import com.chemcool.school.tasks.web.api.dto.TasksDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskOne implements ChemistryTask {
    private UUID id; //Одинаковое поле для всех классов
    private String description; //Одинаковое поле для всех классов
    private TypeOfTask typeOfTask;  //Одинаковое поле для всех классов

    private String one; //Уникальное поле класса

    public TaskOne(TasksDto dto) {
        this.id = dto.getId();
        this.description = dto.getDescription();
        this.typeOfTask = dto.getTypeOfTask();
        this.one = dto.getOne();
    }

    @Override
    public TypeOfTask getTypeOfTask() {
        return typeOfTask;
    }
}
