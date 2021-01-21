package com.chemcool.school.tasks.web.api.fixedanswer.service;

import com.chemcool.school.tasks.fixedanswer.domain.ChemistryFixedAnswerTask;
import com.chemcool.school.tasks.fixedanswer.domain.ChemistryFixedAnswerTaskExample;
import com.chemcool.school.tasks.fixedanswer.domain.ChemistryFixedAnswerTaskFactory;
import com.chemcool.school.tasks.fixedanswer.service.ChemistryFixedAnswerTaskService;
import com.chemcool.school.tasks.web.api.fixedanswer.dto.ChemistryFixedAnswerTaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public String createNewTask(ChemistryFixedAnswerTaskDto task){
        return service.add(
                new ChemistryFixedAnswerTaskExample(
                        task.getChemistryFixedAnswerTaskUuid(),
                        task.getDescription(),
                        task.getRightAnswer(),
                        task.getChapterId(),
                        task.getTypeOfTask()
                )
        );

    }
}
