package com.chemcool.school.tasks.controllers.chemsingleselect;

import com.chemcool.school.tasks.dto.chemsingleselect.ChemistrySingleSelectTaskDto;
import com.chemcool.school.tasks.service.chemsingleselect.ChemistrySingleSelectTaskPresentation;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v.1.0/chemistrySingleSelect")
@RequiredArgsConstructor
public class ChemistrySingleSelectTaskRestController {

    private final ChemistrySingleSelectTaskPresentation presentation;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Создает новую сущность задания типа \"Выбор одного ответа\" по химии.")
    @ResponseBody
    public String createNewTask(@RequestHeader(value = "Authorization") String token,
                                @RequestBody ChemistrySingleSelectTaskDto task) {
        return presentation.add(task, token);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Сохраняет существующую сущность задания типа \"Выбор одного ответа\" по химии.")
    @ResponseBody
    public String updateTask(@RequestBody ChemistrySingleSelectTaskDto task) {
        presentation.update(task);
        return "Update task UUID: " + task.getTaskDtoId();
    }

    @DeleteMapping("/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Удалеят существующую сущность задания типа \"Выбор одного ответа\" по химии по UUID.")
    public String deleteTask(@PathVariable String uuid) {
        presentation.deleteById(uuid);
        return "Сущность с UUID = " + uuid + " была успешно удалена.";
    }

}