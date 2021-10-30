package com.chemcool.school.tasks.domain.exceptions;

import com.chemcool.school.tasks.statuses.TaskType;

public class TaskOfTypeNotFoundException extends Exception{
    public TaskOfTypeNotFoundException(TaskType type) {
        super("No " + type.toString() + " tasks found");
    }
}
