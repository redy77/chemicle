package com.chemcool.school.tasks.service;

import com.chemcool.school.tasks.domain.AbstractTask;
import com.chemcool.school.tasks.domain.SingleSelectTask;
import com.chemcool.school.tasks.domain.representations.SingleSelectRepresentation;
import com.chemcool.school.tasks.infrastructure.storage.TaskRepository;
import com.chemcool.school.tasks.statuses.TaskStatus;
import com.chemcool.school.tasks.statuses.TaskType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public AbstractTask save(AbstractTask task) {
        Integer numberOfTask = taskRepository.findAllByChapterNum(task.getChapterNum()).size();
        task.setTaskNumber(++numberOfTask);
        AbstractTask baseTask = taskRepository.save(task);
        log.info("Task with id {} was saved to db", baseTask.getTaskId());
        return baseTask;
    }

    @Override
    public List<AbstractTask> findAllByTaskType(TaskType taskType) {
        return taskRepository.findAllByTaskType(taskType);
    }

    @Override
    public AbstractTask findById(String taskId) {
        AbstractTask task = null;
        try {
            task = taskRepository.findById(taskId).orElseThrow(()-> new TaskNotFoundException("taskId"));
        } catch (TaskNotFoundException e) {
            e.printStackTrace();
        }
        return task;
    }

    @Override
    public void deleteById(String taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public String updateSingleSelect(String taskId, SingleSelectRepresentation representation) {
        SingleSelectTask dbTask = (SingleSelectTask) findById(taskId);
        SingleSelectTask updatedTask = SingleSelectTask.builder()
                .taskId(dbTask.getTaskId())
                .conditionOfTask(representation.getConditionOfTask())
                .classNum(representation.getClassNum())
                .chapterNum(representation.getChapterNum())
                .paragraphNum(representation.getParagraphNum())
                .rightAnswer(representation.getRightAnswer())
                .answers(representation.getAnswers())
                .status(TaskStatus.UPDATE)
                .type(dbTask.getTaskType())
                .isHidden(dbTask.getIsHidden())
                .build();

        return taskRepository.save(updatedTask).getTaskId();
    }
}
