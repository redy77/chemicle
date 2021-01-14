package com.chemcool.school.tasks.web.api.service;

import com.chemcool.school.tasks.domain.*;
import com.chemcool.school.tasks.service.ChemistryEquationTaskServiceImpl;
import com.chemcool.school.tasks.service.FixedAnswerServiceImpl;
import com.chemcool.school.tasks.service.MatchingTaskOfTwoSidesServiceImpl;
import com.chemcool.school.tasks.service.SingleSelectQuestionImpl;
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
    public ChemistryEquationTaskServiceImpl taskOneService;

    @Autowired
    public FixedAnswerServiceImpl taskTwoService;

    @Autowired
    public MatchingTaskOfTwoSidesServiceImpl taskThreeService;

    @Autowired
    public SingleSelectQuestionImpl singleSelectQuestionService;

    public TasksDto getTaskDtoById(String id) {
        Optional<ChemistryEquationTask> taskOne = taskOneService.getById(id);
        if (taskOne.isPresent()) {
            return new TasksDto(taskOne.get());
        }
        Optional<FixedAnswerTask> taskTwo = taskTwoService.getById(id);
        if (taskTwo.isPresent()) {
            return new TasksDto(taskTwo.get());
        }
        Optional<MatchingOfTwoSidesTask> taskThree = taskThreeService.getById(id);
        if (taskThree.isPresent()) {
            return new TasksDto(taskThree.get());
        }
        Optional<SingleSelectQuestionTask> taskFour = singleSelectQuestionService.getById(id);
        if (taskFour.isPresent()) {
            return new TasksDto(taskFour.get());
        }
        return null;
    }

    public List<TasksDto> getAllTasks() {
        List<TasksDto> list = new ArrayList<>();
        for (ChemistryEquationTask task : taskOneService.getAll()) {
            list.add(new TasksDto(task));
        }
        for (FixedAnswerTask task : taskTwoService.getAll()) {
            list.add(new TasksDto(task));
        }
        for (MatchingOfTwoSidesTask task : taskThreeService.getAll()) {
            list.add(new TasksDto(task));
        }
        for (SingleSelectQuestionTask task : singleSelectQuestionService.getAll()) {
            list.add(new TasksDto(task));
        }
        return list;
    }

    public String add(TasksDto dto) {
        if (dto.getTypeOfTask().isEmpty()) {
            throw new ChemistryTaskEmptyException(""); //todo ексепшн
        }
        TypeOfTask type = dto.getTypeOfTask().get();

        String resultId = "";
        if (type == TypeOfTask.CHEMISTRY_EQUATION) {
            resultId = taskOneService.add(
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
            resultId = taskTwoService.add(
                    new FixedAnswerTask(
                            dto.getId(),
                            dto.getDescription(),
                            dto.getRightAnswer(),
                            dto.getChapterId(),
                            type
                    ));
        } else if (type == TypeOfTask.MATCHING_TASK_OF_TWO_SIDES) {
            resultId = taskThreeService.add(
                    new MatchingOfTwoSidesTask(
                            dto.getId(),
                            dto.getDescription(),
                            dto.getChapterId(),
                            type,
                            dto.getCoupleForMatchings()
                    ));
        } else if (type == TypeOfTask.COMPARISON) {
            resultId = singleSelectQuestionService.add(
                    new SingleSelectQuestionTask(
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
}
