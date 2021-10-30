package com.chemcool.school.theory.service.implementations;

import com.chemcool.school.tasks.models.Task;
import com.chemcool.school.theory.infrastructure.storage.TaskRepository;
import com.chemcool.school.theory.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public Task save(Task task) {
        Task baseTask = taskRepository.save(task);
        log.info("Task with id {} was saved to db", baseTask.getTaskId());
        return baseTask;
    }
}
