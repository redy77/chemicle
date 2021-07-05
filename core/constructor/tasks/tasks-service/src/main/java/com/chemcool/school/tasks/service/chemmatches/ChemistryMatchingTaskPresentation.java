package com.chemcool.school.tasks.service.chemmatches;

import com.chemcool.school.tasks.dto.chemmatches.ChemistryMatchingTaskDto;
import com.chemcool.school.tasks.jwt.JWTParser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChemistryMatchingTaskPresentation {

    private final ChemistryMatchingTaskServiceLayer service;
    private final JWTParser jwtParser;

    public ChemistryMatchingTaskDto getTaskDtoById(String id) {
        return service.getTaskDtoById(id);
    }

    public List<ChemistryMatchingTaskDto> getAllTasks() {
        return service.getAllTasks();
    }

    public List<ChemistryMatchingTaskDto> getAllTasksByChapterId(Integer chapterId) {
        return service.getAllTasksByChapterId(chapterId);
    }

    public String add(ChemistryMatchingTaskDto dto, String token) {
       jwtParser.checkRolesOnAdmin(token);
       return service.add(dto);
    }

    public void update(ChemistryMatchingTaskDto dto) {
       service.update(dto);
    }

    public void deleteById(String id) {
        service.deleteById(id);
    }

}
