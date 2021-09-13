package com.chemcool.school.tasks.service;


import com.chemcool.school.tasks.models.Task;

public interface TaskService<T extends Task> {
    public void create(T task);

    public void update(T task);

    public void delete(T task);
}
