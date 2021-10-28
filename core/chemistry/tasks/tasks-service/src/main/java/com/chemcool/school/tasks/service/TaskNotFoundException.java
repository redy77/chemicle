package com.chemcool.school.tasks.service;

/**
 * @Author : Constantine Lee
 * @Date : 28.10.2021
 * @e-mail : rhowbn@gmail.com
 */
public class TaskNotFoundException extends Exception {
    public TaskNotFoundException(String taskId) {
        super("Task with id " + taskId + " not found");
    }
}
