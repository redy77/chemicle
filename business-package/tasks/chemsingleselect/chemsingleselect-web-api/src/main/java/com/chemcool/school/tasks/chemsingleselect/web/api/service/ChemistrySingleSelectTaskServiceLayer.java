package com.chemcool.school.tasks.chemsingleselect.web.api.service;

import com.chemcool.school.tasks.chemsingleselect.domain.ChemistrySingleSelectTask;
import com.chemcool.school.tasks.chemsingleselect.domain.ChemistrySingleSelectTaskExample;
import com.chemcool.school.tasks.chemsingleselect.service.ChemistrySingleSelectTaskService;
import com.chemcool.school.tasks.chemsingleselect.web.api.dto.ChemistrySingleSelectTaskDto;
import com.chemcool.school.tasks.chemsingleselect.web.api.exception.ChemistryTaskEmptyException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChemistrySingleSelectTaskServiceLayer {

    private final ChemistrySingleSelectTaskService service;

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
                new ChemistrySingleSelectTask(
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
