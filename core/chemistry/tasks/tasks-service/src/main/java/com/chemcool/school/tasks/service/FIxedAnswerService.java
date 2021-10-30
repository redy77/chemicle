package com.chemcool.school.tasks.service;

import com.chemcool.school.tasks.domain.FixedAnswerTask;
import com.chemcool.school.tasks.domain.dto.FixedAnswerDTO;
import com.chemcool.school.tasks.domain.exceptions.TaskNotFoundException;
import com.chemcool.school.tasks.domain.exceptions.TaskOfTypeNotFoundException;
import java.util.List;

public class FIxedAnswerService implements TaskService<FixedAnswerTask, FixedAnswerDTO> {
    @Override
    public void save(FixedAnswerTask fixedAnswerTask) {

    }

    @Override
    public List<FixedAnswerDTO> findAllByTaskType() throws TaskOfTypeNotFoundException {
        return null;
    }

    @Override
    public FixedAnswerDTO findById(String taskId) throws TaskNotFoundException {
        return null;
    }

    @Override
    public void deleteById(String taskId) {

    }

    @Override
    public FixedAnswerDTO update(String taskId, FixedAnswerDTO updatedTaskDTO) throws TaskNotFoundException {
        return null;
    }
}
