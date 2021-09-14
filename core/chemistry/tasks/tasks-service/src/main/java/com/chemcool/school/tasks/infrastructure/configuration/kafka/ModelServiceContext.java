package com.chemcool.school.tasks.infrastructure.configuration.kafka;

import com.chemcool.school.tasks.service.TaskService;
import com.chemcool.school.tasks.service.chemcomparison.ComparisonTaskService;
import com.chemcool.school.tasks.service.chemfixedanswer.FixedAnswerTaskService;
import com.chemcool.school.tasks.service.chemsingleselect.SingleSelectTaskService;
import com.chemcool.school.tasks.statuses.TaskType;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Data
@Component
@Scope("singleton")
public class ModelServiceContext {

    private final Map<TaskType, TaskService> taskServices;

    public ModelServiceContext() {
        this.taskServices = new HashMap<>();
        this.taskServices.put(TaskType.FIXED_ANSWER, new FixedAnswerTaskService());
        this.taskServices.put(TaskType.COMPARISON, new ComparisonTaskService());
        this.taskServices.put(TaskType.SINGLE_SELECT, new SingleSelectTaskService());
    }

    public TaskService getTaskService(TaskType taskType) {
        return this.taskServices.get(taskType);
    }
}
