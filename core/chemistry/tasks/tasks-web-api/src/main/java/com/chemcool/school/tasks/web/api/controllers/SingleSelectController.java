package com.chemcool.school.tasks.web.api.controllers;

import com.chemcool.school.tasks.domain.SingleSelectTask;
import com.chemcool.school.tasks.domain.dto.SingleSelectDTO;
import com.chemcool.school.tasks.domain.exceptions.TaskNotFoundException;
import com.chemcool.school.tasks.domain.exceptions.TaskOfTypeNotFoundException;
import com.chemcool.school.tasks.service.TaskService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author : Constantine Lee
 * @Date : 24.10.2021 
 * @e-mail : rhowbn@gmail.com
 */
@RestController
@RequestMapping("/v1.0/single-select")
public class SingleSelectController {

    @Qualifier("singleSelectService")
    private final TaskService<SingleSelectTask, SingleSelectDTO> taskService;

    @Autowired
    public SingleSelectController(TaskService<SingleSelectTask, SingleSelectDTO> taskService) {
        this.taskService = taskService;
    }


    @GetMapping("/task/{taskId}")
    @ApiOperation(value = "Returns task by task id")
    public SingleSelectDTO findById(@PathVariable String taskId) throws TaskNotFoundException {
        return taskService.findById(taskId);
    }

    @GetMapping("/tasks")
    @ApiOperation(value = "Returns all single select tasks")
    public List<SingleSelectDTO> findAll() throws TaskOfTypeNotFoundException {
        return taskService.findAllByTaskType();
    }

    @PutMapping("/update/{taskId}")
    @ApiOperation(value = "Updates task and returns task id")
    public SingleSelectDTO update(@PathVariable String taskId, @RequestBody @Valid SingleSelectDTO dto) throws TaskNotFoundException {
        return taskService.update(taskId, dto);
    }

    @DeleteMapping("/delete/{taskId}")
    @ApiOperation(value = "Deletes task by id")
    public String delete(@PathVariable String taskId) {
        taskService.deleteById(taskId);
        //todo response entity status
        return "ok";
    }
}
