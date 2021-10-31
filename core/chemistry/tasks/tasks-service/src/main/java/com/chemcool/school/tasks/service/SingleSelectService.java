package com.chemcool.school.tasks.service;

import com.chemcool.school.tasks.domain.AbstractTask;
import com.chemcool.school.tasks.domain.SingleSelectTask;
import com.chemcool.school.tasks.domain.converters.DTOConverter;
import com.chemcool.school.tasks.domain.exceptions.TaskNotFoundException;
import com.chemcool.school.tasks.domain.exceptions.TaskOfTypeNotFoundException;
import com.chemcool.school.tasks.domain.dto.SingleSelectDTO;
import com.chemcool.school.tasks.infrastructure.storage.TaskRepository;
import com.chemcool.school.tasks.statuses.TaskStatus;
import com.chemcool.school.tasks.statuses.TaskType;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service("singleSelectService")
@RequiredArgsConstructor
public class SingleSelectService implements TaskService<SingleSelectTask>{

    private final TaskRepository<SingleSelectTask> repository;
    private final DTOConverter<SingleSelectTask, SingleSelectDTO> dtoConverter;
    private final TaskType taskType = TaskType.SINGLE_SELECT;

    @Override
    public void save(SingleSelectTask task) {
        //counts quantity of tasks with given chapter number
        int numberOfTask = repository.findAllByChapterNum(task.getChapterNum()).size();
        task.setTaskNumber(++numberOfTask);
        repository.save(task);
    }

}
