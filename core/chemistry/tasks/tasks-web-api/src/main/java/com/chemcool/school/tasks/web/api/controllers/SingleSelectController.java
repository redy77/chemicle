package com.chemcool.school.tasks.web.api.controllers;

import com.chemcool.school.tasks.domain.AbstractTask;
import com.chemcool.school.tasks.domain.SingleSelectTask;
import com.chemcool.school.tasks.domain.representations.SingleSelectRepresentation;
import com.chemcool.school.tasks.service.TaskNotFoundException;
import com.chemcool.school.tasks.service.TaskOfTypeNotFound;
import com.chemcool.school.tasks.service.TaskService;
import com.chemcool.school.tasks.statuses.TaskType;
import com.chemcool.school.tasks.web.api.dto.SingleSelectDto;
import com.chemcool.school.tasks.web.api.service.DtoToRepresentationConverter;
import com.chemcool.school.tasks.web.api.service.TaskToDtoConverter;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author : Constantine Lee
 * @Date : 24.10.2021 
 * @e-mail : rhowbn@gmail.com
 */
@RestController
@RequestMapping("/v1.0/single-select")
@RequiredArgsConstructor
public class SingleSelectController {

    private final TaskService taskService;
    private final TaskToDtoConverter taskToDtoConverter;
    private final DtoToRepresentationConverter dtoToRepresentationConverter;

    @GetMapping("/task/{taskId}")
    @ApiOperation(value = "Returns task by task id")
    public SingleSelectDto findById(@PathVariable String taskId) throws TaskNotFoundException {
        SingleSelectTask task = (SingleSelectTask) taskService.findById(taskId);
        SingleSelectDto dto = taskToDtoConverter.singleSelectDto(task);
        return dto;
    }

    @GetMapping("/tasks")
    @ApiOperation(value = "Returns all single select tasks")
    public List<SingleSelectDto> findAll() throws TaskOfTypeNotFound {
        List<AbstractTask> tasks = taskService.findAllByTaskType(TaskType.SINGLE_SELECT);
        return tasks.stream()
                .map(task -> (SingleSelectTask) task)
                .map(taskToDtoConverter::singleSelectDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/update/{taskId}")
    @ApiOperation(value = "Updates task and returns task id")
    public AbstractTask update(@PathVariable String taskId, @RequestBody @Valid SingleSelectDto dto) throws TaskNotFoundException {
        SingleSelectRepresentation representation = dtoToRepresentationConverter.toRepresentation(dto);
        return taskService.update(taskId, representation);

    }

    @DeleteMapping("/delete/{taskId}")
    @ApiOperation(value = "Deletes task by id")
    public String delete(@PathVariable String taskId) {
        taskService.deleteById(taskId);
        //todo response entity status
        return "ok";
    }
}
