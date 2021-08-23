package com.chemcool.school.lesson.web.api.service;

import com.chemcool.school.lesson.web.api.dto.ChemSingleSelectTaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChemSingleSelectTaskPresentation {

    private final ChemSingleSelectTaskServiceLayer serviceLayer;

    public ChemSingleSelectTaskDto getTaskDtoByIdDto(String id) {
        return serviceLayer.getTaskDtoByIdDto(id);
    }

    public List<ChemSingleSelectTaskDto> getAllTasksDto() {
        return serviceLayer.getAllTasksDto();
    }

    public List<ChemSingleSelectTaskDto> getAllTasksByReferenceIdDto(Integer referenceId) {
        return serviceLayer.getAllTasksByReferenceIdDto(referenceId);
    }

    public List<ChemSingleSelectTaskDto> getAllTasksByChapterIdDto(Integer chapterId) {
        return serviceLayer.getAllTasksByChapterIdDto(chapterId);
    }

    public List<ChemSingleSelectTaskDto> getAllTasksByReferenceIdAndChapterIdDto(Integer referenceId, Integer chapterId) {
        return serviceLayer.getAllTasksByReferenceIdAndChapterIdDto(referenceId, chapterId);
    }

    public ChemSingleSelectTaskDto getRandomChemSingleSelectTaskDto() {
        return serviceLayer.getRandomChemSingleSelectTaskDto();
    }
}
