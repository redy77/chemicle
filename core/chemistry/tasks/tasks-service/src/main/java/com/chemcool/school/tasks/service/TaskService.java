package com.chemcool.school.tasks.service;


import com.chemcool.school.tasks.domain.exceptions.TaskNotFoundException;
import com.chemcool.school.tasks.domain.exceptions.TaskOfTypeNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import java.util.List;

public interface TaskService<Task, DTO> {
    void save(Task task);

    List<DTO> findAllByTaskType() throws TaskOfTypeNotFoundException;

    DTO findById(String taskId) throws TaskNotFoundException;

    void deleteById(String taskId) throws EmptyResultDataAccessException;

    DTO update(String taskId, DTO updatedTaskDTO) throws TaskNotFoundException;
}
