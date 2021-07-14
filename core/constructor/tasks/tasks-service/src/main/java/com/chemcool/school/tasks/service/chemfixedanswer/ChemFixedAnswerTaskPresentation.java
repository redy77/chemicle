package com.chemcool.school.tasks.service.chemfixedanswer;

import com.chemcool.school.tasks.domain.chemfixedanswer.ChemFixedAnswerTask;
import com.chemcool.school.tasks.dto.chemfixedanswer.ChemFixedAnswerTaskDto;
import com.chemcool.school.tasks.jwt.JWTParser;
import com.chemcool.school.tasks.dto.chemfixedanswer.ChemFixedAnswerTaskCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ChemFixedAnswerTaskPresentation {


    private final ChemFixedAnswerTaskServiceLayer serviceLayer;
    private final JWTParser jwtParser;


    public String createNewFixedAnswerTask(ChemFixedAnswerTaskCreateDto taskDto, String token){
        jwtParser.checkRolesOnAdmin(token);
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
