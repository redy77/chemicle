package com.chemcool.school.tasks.web.api.single.select.service;

import com.chemcool.school.tasks.domain.ChemistrySingleSelectTask;
import com.chemcool.school.tasks.domain.ChemistrySingleSelectTaskExample;
import com.chemcool.school.tasks.service.ChemistrySingleSelectTaskServiceImpl;
import com.chemcool.school.tasks.web.api.exception.ChemistryTaskEmptyException;
import com.chemcool.school.tasks.web.api.single.select.dto.ChemistrySingleSelectTaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChemistrySingleSelectTaskServiceLayer {

    private final ChemistrySingleSelectTaskServiceImpl service;

    public ChemistrySingleSelectTaskDto getTaskDtoById(String id) {
        return service.getById(id).map(ChemistrySingleSelectTaskDto::new).orElse(null);
    }

    public List<ChemistrySingleSelectTaskDto> getAllTasks() {
        List<ChemistrySingleSelectTaskDto> list = new ArrayList<>();
        for (ChemistrySingleSelectTask task : service.getAll()) {
            list.add(new ChemistrySingleSelectTaskDto(task));
        }
        return list;
    }

    public List<ChemistrySingleSelectTaskDto> getAllTasksByChapterId(String chapterId) {
        List<ChemistrySingleSelectTaskDto> list = new ArrayList<>();
        for (ChemistrySingleSelectTask task : service.getAllByChapterId(chapterId)) {
            list.add(new ChemistrySingleSelectTaskDto(task));
        }
        return list;
    }

    public String add(ChemistrySingleSelectTaskDto dto) {
        validate(dto);
        return service.add(
                new ChemistrySingleSelectTaskExample(
                        dto.getChemistrySingleSelectTaskUuid(),
                        dto.getDescription(),
                        dto.getRightAnswer(),
                        dto.getChapterId(),
                        dto.getTypeOfTask(),
                        dto.getIncorrectAnswer1(),
                        dto.getIncorrectAnswer2(),
                        dto.getIncorrectAnswer3()
                )
        );
    }

    public void update(ChemistrySingleSelectTaskDto dto) {
        validate(dto);
        service.update(
                new ChemistrySingleSelectTaskExample( //todo может быть всё-таки через ChemistrySingleSelectTask
                        dto.getChemistrySingleSelectTaskUuid(),
                        dto.getDescription(),
                        dto.getRightAnswer(),
                        dto.getChapterId(),
                        dto.getTypeOfTask(),
                        dto.getIncorrectAnswer1(),
                        dto.getIncorrectAnswer2(),
                        dto.getIncorrectAnswer3()
                )
        );
    }

    public void deleteById(String id) {
        service.deleteById(id);
    }

    private void validate(ChemistrySingleSelectTaskDto dto) {
        if (
                dto.getDescription().isEmpty() //todo добавить все обязательные поля для проверки заполнения
        ) {
            throw new ChemistryTaskEmptyException("Необходимые поля пустые, проверьте пожалуйста бланк заполнения задания.");
        }
    }
}
