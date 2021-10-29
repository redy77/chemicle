package com.chemcool.school.tasks.service;

import com.chemcool.school.tasks.statuses.TaskType;

/**
 * @Author : Constantine Lee
 * @Date : 29.10.2021
 * @e-mail : rhowbn@gmail.com
 */
public class TaskOfTypeNotFound extends Exception{
    public TaskOfTypeNotFound(TaskType type) {
        super("No " + type.toString() + " tasks found");
    }
}
