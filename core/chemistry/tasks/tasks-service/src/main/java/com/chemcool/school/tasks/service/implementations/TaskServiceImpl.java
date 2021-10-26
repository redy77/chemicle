package com.chemcool.school.tasks.service.implementations;

import com.chemcool.school.tasks.infrastructure.storage.TaskRepository;
import com.chemcool.school.tasks.models.Task;
import com.chemcool.school.tasks.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author : Constantine Lee
 * @Date : 26.10.2021
 * @e-mail : rhowbn@gmail.com
 */
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
