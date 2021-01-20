package com.chemcool.school.tasks.web.api.matching.service;

import com.chemcool.school.tasks.domain.ChemistryMatchingTask;
import com.chemcool.school.tasks.domain.ChemistryMatchingTaskExample;
import com.chemcool.school.tasks.service.ChemistryMatchingTaskServiceImpl;
import com.chemcool.school.tasks.web.api.exception.ChemistryTaskEmptyException;
import com.chemcool.school.tasks.web.api.matching.dto.ChemistryMatchingTaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChemistryMatchingTaskPresentation {

    private final ChemistryMatchingTaskServiceImpl service;

    public ChemistryMatchingTaskDto getTaskDtoById(String id) {
        return service.getById(id).map(ChemistryMatchingTaskDto::new).orElse(null);
    }

    public List<ChemistryMatchingTaskDto> getAllTasks() {
        List<ChemistryMatchingTaskDto> list = new ArrayList<>();
        for (ChemistryMatchingTask task : service.getAll()) {
            list.add(new ChemistryMatchingTaskDto(task));
        }
        return list;
    }

    public List<ChemistryMatchingTaskDto> getAllTasksByChapterId(String chapterId) {
        List<ChemistryMatchingTaskDto> list = new ArrayList<>();
        for (ChemistryMatchingTask task : service.getAllByChapterId(chapterId)) {
            list.add(new ChemistryMatchingTaskDto(task));
        }
        return list;
    }

    public String add(ChemistryMatchingTaskDto dto) {
        validate(dto);
        return service.add(
                new ChemistryMatchingTask(
                        dto.getChemistryMatchingTaskUuid(),
                        dto.getDescription(),
                        dto.getChapterId(),
                        dto.getTypeOfTask(),
                        dto.getCoupleForMatchingList()
                )
        );
    }

    public void update(ChemistryMatchingTaskDto dto) {
        validate(dto);
        service.update(
                new ChemistryMatchingTask(
                        dto.getChemistryMatchingTaskUuid(),
                        dto.getDescription(),
                        dto.getChapterId(),
                        dto.getTypeOfTask(),
                        dto.getCoupleForMatchingList()
                )
        );
    }

    public void deleteById(String id) {
        service.deleteById(id);
    }

    private void validate(ChemistryMatchingTaskDto dto) {
        if (dto.getDescription().isEmpty()){
            throw new ChemistryTaskEmptyException("Необходимые поля пустые, проверьте пожалуйста бланк заполнения задания.");
        }
    }
}
