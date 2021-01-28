package com.chemcool.school.chemmatches.web.api.controllers;

import com.chemcool.school.chemmatches.web.api.dto.ChemistryMatchingTaskDto;
import com.chemcool.school.chemmatches.web.api.service.ChemistryMatchingTaskPresentation;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1.0/tasks/matching")
@RequiredArgsConstructor
public class ChemistryMatchingTaskRestController {
    private final ChemistryMatchingTaskPresentation presentation;

    @GetMapping
    @ApiOperation("Возвращает все задания типа \"matching(сопоставления)\" по химии.")
    public List<ChemistryMatchingTaskDto> getAllTasks(){
        return presentation.getAllTasks();
    }

    @GetMapping("/{uuid}")
    @ApiOperation("Возвращает дто сущности задания типа \"matching(сопоставления)\" по химии по UUID.")
    public ChemistryMatchingTaskDto getTaskById(@PathVariable String uuid){
        return presentation.getTaskDtoById(uuid);
    }

    @PostMapping
    @ApiOperation("Создает новую сущность задания типа \"matching(сопоставления)\" по химии.")
    @ResponseBody
    public String createNewTask(@RequestBody ChemistryMatchingTaskDto task) {
        return "New task UUID: " + presentation.add(task);
    }

    @PutMapping
    @ApiOperation("Обновляет существующую сущность задания типа \"matching(сопоставления)\" по химии.")
    @ResponseBody
    public String updateTask(@RequestBody ChemistryMatchingTaskDto task) {
        presentation.update(task);
        return "Update task UUID: " + task.getTaskId();
    }

    @DeleteMapping("/{uuid}")
    @ApiOperation("Удалеят существующую сущность задания типа \"matching(сопоставления)\" по химии по UUID.")
    public String deleteTask(@PathVariable String uuid) {
        presentation.deleteById(uuid);
        return "Сущность с UUID = " + uuid + " была успешно удалена.";
    }

}
