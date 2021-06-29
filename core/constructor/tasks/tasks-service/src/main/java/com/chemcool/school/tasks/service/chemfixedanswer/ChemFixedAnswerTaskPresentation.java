package com.chemcool.school.tasks.service.chemfixedanswer;

import com.chemcool.school.tasks.dto.chemfixedanswer.ChemFixedAnswerTaskCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ChemFixedAnswerTaskPresentation {


    private final ChemFixedAnswerTaskServiceLayer serviceLayer;


    public String createNewFixedAnswerTask(ChemFixedAnswerTaskCreateDto taskDto){
        return serviceLayer.createNewFixedAnswerTask(taskDto);
    }

    public void updateFixedAnswerTask(ChemFixedAnswerTaskCreateDto taskDto){
        serviceLayer.updateFixedAnswerTask(taskDto);
    }

    public void deleteFixedAnswerTask(String id){
        serviceLayer.deleteFixedAnswerTask(id);
    }

    public boolean checkAnswer(String taskId, String userAnswer) {
        return serviceLayer.checkAnswer(taskId, userAnswer);
    }


}
