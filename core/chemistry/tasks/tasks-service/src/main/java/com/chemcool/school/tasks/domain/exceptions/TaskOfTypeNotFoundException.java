package com.chemcool.school.tasks.domain.exceptions;

import com.chemcool.school.tasks.statuses.TaskType;

/**
 * @Author : Constantine Lee
 * @Date : 29.10.2021
 * @e-mail : rhowbn@gmail.com
 */
public class TaskOfTypeNotFoundException extends Exception{
    public TaskOfTypeNotFoundException(TaskType type) {
        super("No " + type.toString() + " tasks found");
    }
}
