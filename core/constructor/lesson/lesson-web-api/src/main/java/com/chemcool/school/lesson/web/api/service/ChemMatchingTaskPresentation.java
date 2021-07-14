package com.chemcool.school.lesson.web.api.service;

import com.chemcool.school.lesson.web.api.dto.ChemMatchingTaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChemMatchingTaskPresentation {

    private final ChemMatchingTaskServiceLayer service;

    public ChemMatchingTaskDto getTaskDtoByIdDto(String id) {
        return service.getTaskDtoByIdDto(id);
    }

    public List<ChemMatchingTaskDto> getAllTasksDto() {
        return service.getAllTasksDto();
    }

    public List<ChemMatchingTaskDto> getAllTasksByReferenceIdDto(Integer referenceId) {
        return service.getAllTasksByReferenceIdDto(referenceId);
    }

    public List<ChemMatchingTaskDto> getAllTasksByChapterIdDto(Integer chapterId) {
        return service.getAllTasksByChapterIdDto(chapterId);
    }

    public List<ChemMatchingTaskDto> getAllTasksByReferenceIdAndChapterIdDto(Integer referenceId, Integer chapterId) {
        return service.getAllTasksByReferenceIdAndChapterIdDto(referenceId, chapterId);
    }

    public List<ChemMatchingTaskDto> getAllTasks() {
        return service.getAllTasks();
    }

    public ChemMatchingTaskDto getTaskDtoById(String uuid) {
        return service.getTaskDtoById(uuid);
    }

    public ChemMatchingTaskDto getRandomChemMatchingTaskDto() {
        return service.getRandomChemMatchingTaskDto();
    }
}
