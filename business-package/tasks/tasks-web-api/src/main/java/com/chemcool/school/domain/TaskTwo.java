package com.chemcool.school.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskTwo implements ChemistryTask {
    private UUID id;
    private String common;
    private String two;
    private TaskType taskType;

    @Override
    public TaskType getTaskType() {
        return taskType;
    }
}
