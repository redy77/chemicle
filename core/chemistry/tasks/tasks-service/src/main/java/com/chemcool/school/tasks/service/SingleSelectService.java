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

/**
 * @Author : Constantine Lee
 * @Date : 29.10.2021
 * @e-mail : rhowbn@gmail.com
 */
@Service("singleSelectService")
@RequiredArgsConstructor
public class SingleSelectService implements TaskService<SingleSelectTask, SingleSelectDTO>{

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

    @Override
    public List<SingleSelectDTO> findAllByTaskType() throws TaskOfTypeNotFoundException {
        List<SingleSelectTask> tasks = repository.findAllByTaskType(taskType);
        if (tasks.isEmpty()) {
            throw new TaskOfTypeNotFoundException(taskType);
        }
        return tasks.stream()
                .map(dtoConverter::taskToDto)
                .collect(Collectors.toList());
    }

    @Override
    public SingleSelectDTO findById(String taskId) throws TaskNotFoundException, ClassCastException {
        SingleSelectTask task = repository.findById(taskId).orElseThrow(()-> new TaskNotFoundException(taskId));
        return dtoConverter.taskToDto((SingleSelectTask) task);
    }

    @Override
    public void deleteById(String taskId) throws EmptyResultDataAccessException {
        repository.deleteById(taskId);
    }

    @Override
    public SingleSelectDTO update(String taskId, SingleSelectDTO dto) throws TaskNotFoundException, ClassCastException {
        AbstractTask dbTask = repository.findById(taskId).orElseThrow(()-> new TaskNotFoundException(taskId));
        SingleSelectTask updatedTask = SingleSelectTask.builder()
                .taskId(dbTask.getTaskId())
                .type(dbTask.getTaskType())
                .status(TaskStatus.UPDATE)
                .isHidden(dbTask.getIsHidden())
                .taskNumber(dbTask.getTaskNumber())
                .conditionOfTask(dto.getConditionOfTask())
                .chapterNum(dto.getChapterNum())
                .classNum(dto.getClassNum())
                .paragraphNum(dto.getParagraphNum())
                .rightAnswer(dto.getRightAnswer())
                .answers(dto.getAnswers())
                .build();

        repository.save(updatedTask);
        return dtoConverter.taskToDto(updatedTask);
    }
}
