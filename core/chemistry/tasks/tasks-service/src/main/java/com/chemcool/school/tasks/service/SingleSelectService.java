package com.chemcool.school.tasks.service;

import com.chemcool.school.tasks.domain.SingleSelectTask;
import com.chemcool.school.tasks.infrastructure.storage.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("singleSelectService")
@RequiredArgsConstructor
public class SingleSelectService implements TaskService<SingleSelectTask>{

    private final TaskRepository<SingleSelectTask> repository;

    @Override
    public void save(SingleSelectTask task) {
        //counts quantity of tasks with given chapter number
        int numberOfTask = repository.findAllByChapterNum(task.getChapterNum()).size();
            task.setTaskNumber(++numberOfTask);

        repository.save(task);
    }

}
