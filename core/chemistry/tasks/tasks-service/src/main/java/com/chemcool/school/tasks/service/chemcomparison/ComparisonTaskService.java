package com.chemcool.school.tasks.service.chemcomparison;


import com.chemcool.school.tasks.domain.chemcomparison.ComparisonTask;
import com.chemcool.school.tasks.service.TaskService;

public class ComparisonTaskService implements TaskService<ComparisonTask> {

    @Override
    public void create(ComparisonTask task) {
        System.out.println("create");
    }

    @Override
    public void update(ComparisonTask task) {
        System.out.println("update");
    }

    @Override
    public void delete(ComparisonTask task) {

    }
}
