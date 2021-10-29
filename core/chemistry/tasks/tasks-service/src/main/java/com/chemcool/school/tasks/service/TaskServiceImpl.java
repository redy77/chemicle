package com.chemcool.school.tasks.service;

import com.chemcool.school.tasks.domain.AbstractTask;
import com.chemcool.school.tasks.domain.Comparison;
import com.chemcool.school.tasks.domain.FixedAnswerTask;
import com.chemcool.school.tasks.domain.SingleSelectTask;
import com.chemcool.school.tasks.domain.representations.ComparisonRepresentation;
import com.chemcool.school.tasks.domain.representations.FixedAnswerRepresentation;
import com.chemcool.school.tasks.domain.representations.SingleSelectRepresentation;
import com.chemcool.school.tasks.domain.representations.TaskRepresentation;
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
    public List<AbstractTask> findAllByTaskType(TaskType taskType) throws TaskOfTypeNotFound {
        List<AbstractTask> tasks = taskRepository.findAllByTaskType(taskType);
        if (tasks.size() == 0) {
            throw new TaskOfTypeNotFound(taskType);
        }
        return tasks;
    }

    @Override
    public AbstractTask findById(String taskId) throws TaskNotFoundException {
        AbstractTask task = null;
        task = taskRepository.findById(taskId).orElseThrow(()-> new TaskNotFoundException("taskId"));
        return task;
    }

    @Override
    public void deleteById(String taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public AbstractTask update(String taskId, TaskRepresentation representation) throws TaskNotFoundException {
        AbstractTask dbTask = findById(taskId);
        dbTask.setTaskId(representation.getTaskId());
        dbTask.setConditionOfTask(representation.getConditionOfTask());
        dbTask.setClassNum(representation.getClassNum());
        dbTask.setChapterNum(representation.getChapterNum());
        dbTask.setParagraphNum(representation.getParagraphNum());

        if (dbTask instanceof SingleSelectTask) {
            SingleSelectTask updatedTask = (SingleSelectTask) dbTask;
            SingleSelectRepresentation singleSelectRepresentation = (SingleSelectRepresentation) representation;
            updatedTask.setRightAnswer(singleSelectRepresentation.getRightAnswer());
            updatedTask.setAnswers(singleSelectRepresentation.getAnswers());
            taskRepository.save(updatedTask);
            return updatedTask;

        } else if(dbTask instanceof FixedAnswerTask) {
            FixedAnswerTask updatedTask = (FixedAnswerTask) dbTask;
            FixedAnswerRepresentation fixedAnswerRepresentation = (FixedAnswerRepresentation) representation;
            updatedTask.setAnswer(fixedAnswerRepresentation.getAnswer());
            taskRepository.save(updatedTask);
            return updatedTask;

        } else if(dbTask instanceof Comparison) {
            //todo

            return null;
        }
        return dbTask;
    }
}
