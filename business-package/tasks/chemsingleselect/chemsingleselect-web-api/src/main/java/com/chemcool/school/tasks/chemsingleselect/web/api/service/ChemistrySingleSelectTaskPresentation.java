package com.chemcool.school.tasks.chemsingleselect.web.api.service;

import com.chemcool.school.tasks.chemsingleselect.web.api.dto.ChemistrySingleSelectTaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChemistrySingleSelectTaskPresentation {

    private final ChemistrySingleSelectTaskPresentation presentation;

    public ChemistrySingleSelectTaskDto getTaskDtoById(String id) {
        return presentation.getTaskDtoById(id);
    }

    public List<ChemistrySingleSelectTaskDto> getAllTasks() {
        return presentation.getAllTasks();
    }

    public List<ChemistrySingleSelectTaskDto> getAllTasksByChapterId(String chapterId) {
        return presentation.getAllTasksByChapterId(chapterId);
    }

    public String add(ChemistrySingleSelectTaskDto dto) {
        return presentation.add(dto);
    }

    public void update(ChemistrySingleSelectTaskDto dto) {
        presentation.update(dto);
    }

    public void deleteById(String id) {
        presentation.deleteById(id);
    }
}
