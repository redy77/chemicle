package com.chemcool.school.tasks.web.api.service;

import com.chemcool.school.tasks.domain.*;
import com.chemcool.school.tasks.service.ChemistryEquationTaskServiceImpl;
import com.chemcool.school.tasks.service.ChemistryFixedAnswerTaskServiceImpl;
import com.chemcool.school.tasks.service.ChemistryMatchingTaskServiceImpl;
import com.chemcool.school.tasks.service.ChemistrySingleSelectTaskServiceImpl;
import com.chemcool.school.tasks.web.api.dto.TasksDto;
import com.chemcool.school.tasks.web.api.exception.ChemistryTaskEmptyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskDtoService {

    @Autowired
    public ChemistryEquationTaskServiceImpl equationTaskService;

    @Autowired
    public ChemistryFixedAnswerTaskServiceImpl fixedAnswerTaskService;

    @Autowired
    public ChemistryMatchingTaskServiceImpl matchingTaskService;

    @Autowired
    public ChemistrySingleSelectTaskServiceImpl singleSelectTaskService;

    public TasksDto getTaskDtoById(String id) {
        Optional<ChemistryEquationTask> taskOne = equationTaskService.getById(id);
        if (taskOne.isPresent()) {
            return new TasksDto(taskOne.get());
        }
        Optional<ChemistryFixedAnswerTask> taskTwo = fixedAnswerTaskService.getById(id);
        if (taskTwo.isPresent()) {
            return new TasksDto(taskTwo.get());
        }
        Optional<ChemistryMatchingTask> taskThree = matchingTaskService.getById(id);
        if (taskThree.isPresent()) {
            return new TasksDto(taskThree.get());
        }
        Optional<ChemistrySingleSelectTask> taskFour = singleSelectTaskService.getById(id);
        return taskFour.map(TasksDto::new).orElse(null);
    }

    public List<TasksDto> getAllTasks() {
        List<TasksDto> list = new ArrayList<>();
        for (ChemistryEquationTask task : equationTaskService.getAll()) {
            list.add(new TasksDto(task));
        }
        for (ChemistryFixedAnswerTask task : fixedAnswerTaskService.getAll()) {
            list.add(new TasksDto(task));
        }
        for (ChemistryMatchingTask task : matchingTaskService.getAll()) {
            list.add(new TasksDto(task));
        }
        for (ChemistrySingleSelectTask task : singleSelectTaskService.getAll()) {
            list.add(new TasksDto(task));
        }
        return list;
    }

    public List<TasksDto> getAllTasksByChapterId(String chapterId) {
        List<TasksDto> list = new ArrayList<>();
        for (ChemistryEquationTask task : equationTaskService.getAllByChapterId(chapterId) ) {
            list.add(new TasksDto(task));
        }
        for (ChemistryFixedAnswerTask task : fixedAnswerTaskService.getAllByChapterId(chapterId) ) {
            list.add(new TasksDto(task));
        }
        for (ChemistryMatchingTask task : matchingTaskService.getAllByChapterId(chapterId) ) {
            list.add(new TasksDto(task));
        }
        for (ChemistrySingleSelectTask task : singleSelectTaskService.getAllByChapterId(chapterId) ) {
            list.add(new TasksDto(task));
        }
        return list;
    }

    public String add(TasksDto dto) {
        if (dto.getTypeOfTask().isEmpty()) {
            throw new ChemistryTaskEmptyException("Поле typeOfTask не может быть пустым");
        }
        TypeOfTask type = dto.getTypeOfTask().get();

        String resultId = "";
        if (type == TypeOfTask.CHEMISTRY_EQUATION) {
            resultId = equationTaskService.add(
                    new ChemistryEquationTask(
                            dto.getId(),
                            dto.getDescription(),
                            dto.getRightProducts(),
                            dto.getChapterId(),
                            type,
                            dto.getReagents(),
                            dto.getWrongProducts1(),
                            dto.getWrongProducts2(),
                            dto.getWrongProducts3()
                    ));
        } else if (type == TypeOfTask.FIXED_ANSWER) {
            resultId = fixedAnswerTaskService.add(
                    new ChemistryFixedAnswerTask(
                            dto.getId(),
                            dto.getDescription(),
                            dto.getRightAnswer(),
                            dto.getChapterId(),
                            type
                    ));
        } else if (type == TypeOfTask.MATCHING) {
            resultId = matchingTaskService.add(
                    new ChemistryMatchingTask(
                            dto.getId(),
                            dto.getDescription(),
                            dto.getChapterId(),
                            type,
                            dto.getCoupleForMatchingList()
                    ));
        } else if (type == TypeOfTask.SINGLE_SELECT) {
            resultId = singleSelectTaskService.add(
                    new ChemistrySingleSelectTask(
                            dto.getId(),
                            dto.getDescription(),
                            dto.getRightAnswer(),
                            dto.getChapterId(),
                            type,
                            dto.getIncorrectAnswer1(),
                            dto.getIncorrectAnswer2(),
                            dto.getIncorrectAnswer3()
                    ));
        }
        return resultId;
    }

    public void deleteById(String id) {
        TasksDto dto = getTaskDtoById(id);

        if (dto.getTypeOfTask().isEmpty()) {
            throw new ChemistryTaskEmptyException("Поле typeOfTask не может быть пустым");
        }
        TypeOfTask type = dto.getTypeOfTask().get();

        deleteByIdAndType(id, type);
    }

    public void deleteByIdAndType(String id, TypeOfTask type) {
        if (type == TypeOfTask.CHEMISTRY_EQUATION) {
             equationTaskService.deleteById(id);
        } else if (type == TypeOfTask.FIXED_ANSWER) {
            fixedAnswerTaskService.deleteById(id);
        } else if (type == TypeOfTask.MATCHING) {
            matchingTaskService.deleteById(id);
        } else if (type == TypeOfTask.SINGLE_SELECT) {
            singleSelectTaskService.deleteById(id);
        }
    }
}
