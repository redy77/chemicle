package com.chemcool.school.tasks.web.api.single.select.service;

import com.chemcool.school.tasks.web.api.single.select.dto.ChemistrySingleSelectTaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChemistrySingleSelectTaskPresentation {

    private final ChemistrySingleSelectTaskServiceLayer service;

    public ChemistrySingleSelectTaskDto getTaskDtoById(String id) {
        return service.getTaskDtoById(id);
    }

    public List<ChemistrySingleSelectTaskDto> getAllTasks() {
        return service.getAllTasks();
    }

    public List<ChemistrySingleSelectTaskDto> getAllTasksByChapterId(String chapterId) {
        return service.getAllTasksByChapterId(chapterId);
    }

    public String add(ChemistrySingleSelectTaskDto dto) {
        return service.add(dto);
    }

    public void update(ChemistrySingleSelectTaskDto dto) {
        service.update(dto);
    }

    public void deleteById(String id) {
        service.deleteById(id);
    }
}
