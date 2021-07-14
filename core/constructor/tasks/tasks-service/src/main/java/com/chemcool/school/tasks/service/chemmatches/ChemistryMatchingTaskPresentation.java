package com.chemcool.school.tasks.service.chemmatches;

import com.chemcool.school.tasks.dto.chemmatches.ChemistryMatchingTaskDto;
import com.chemcool.school.tasks.jwt.JWTParser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChemistryMatchingTaskPresentation {

    private final ChemistryMatchingTaskServiceLayer service;
    private final JWTParser jwtParser;


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
