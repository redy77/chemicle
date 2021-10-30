package com.chemcool.school.tasks.domain.exceptions;

public class TaskNotFoundException extends Exception {
    public TaskNotFoundException(String taskId) {
        super("Task with id " + taskId + " not found");
    }
}
