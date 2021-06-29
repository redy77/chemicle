package com.chemcool.school.tasks.service.chemmatches;

import com.chemcool.school.tasks.dto.chemmatches.ChemistryMatchingTaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChemistryMatchingTaskPresentation {

    private final ChemistryMatchingTaskServiceLayer service;


    public String add(ChemistryMatchingTaskDto dto) {
       return service.add(dto);
    }

    public void update(ChemistryMatchingTaskDto dto) {
       service.update(dto);
    }

    public void deleteById(String id) {
        service.deleteById(id);
    }
}
