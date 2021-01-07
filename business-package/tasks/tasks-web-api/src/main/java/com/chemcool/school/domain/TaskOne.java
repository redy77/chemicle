package com.chemcool.school.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
public class TaskOne implements ChemistryTask {
    private UUID id;
    private String common;
    private String one;
    private TaskType taskType;

    public TaskOne() {}

    public TaskOne(String common, String one, TaskType taskType) {
        this.common = common;
        this.one = one;
        this.taskType = taskType;
    }

    @Override
    public TaskType getTaskType() {
        return taskType;
    }
}
