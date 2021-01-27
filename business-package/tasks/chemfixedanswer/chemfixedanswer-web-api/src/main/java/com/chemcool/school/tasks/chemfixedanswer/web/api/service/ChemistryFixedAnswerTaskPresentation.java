package com.chemcool.school.tasks.chemfixedanswer.web.api.service;

import com.chemcool.school.tasks.chemfixedanswer.domain.ChemistryFixedAnswerTask;
import com.chemcool.school.tasks.chemfixedanswer.domain.ChemistryFixedAnswerTaskExample;
import com.chemcool.school.tasks.chemfixedanswer.service.ChemistryFixedAnswerTaskService;
import com.chemcool.school.tasks.chemfixedanswer.web.api.dto.ChemistryFixedAnswerTaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChemistryFixedAnswerTaskPresentation {

    @Autowired
    private final ChemistryFixedAnswerTaskService service;

    public List<ChemistryFixedAnswerTaskDto> getAllChemistryFixedAnswerDto () {
        List<ChemistryFixedAnswerTaskDto> list = new ArrayList<>();
        for(ChemistryFixedAnswerTask task : service.getAll()){
            list.add(new ChemistryFixedAnswerTaskDto(task));
        }
        return list;
    }

    public Optional<ChemistryFixedAnswerTask> getFixedAnswerTaskById(String id) {
        return service.getById(id);
    }

    public String createNewFixedAnswerTask(ChemistryFixedAnswerTaskDto taskDto){
        return service.add(
                new ChemistryFixedAnswerTaskExample(
                        taskDto.getDescription(),
                        taskDto.getRightAnswer(),
                        taskDto.getChapterId(),
                        taskDto.getTypeOfTask()
                )
        );
    }

    public void updateFixedAnswerTask(ChemistryFixedAnswerTaskDto taskDto){
        service.update(
                new ChemistryFixedAnswerTask(
                        taskDto.getChemistryFixedAnswerTaskUuid(),
                        taskDto.getDescription(),
                        taskDto.getRightAnswer(),
                        taskDto.getChapterId(),
                        taskDto.getTypeOfTask()
                )
        );
    }

    public void deleteFixedAnswerTask(String id){
        service.deleteById(id);
    }
}
