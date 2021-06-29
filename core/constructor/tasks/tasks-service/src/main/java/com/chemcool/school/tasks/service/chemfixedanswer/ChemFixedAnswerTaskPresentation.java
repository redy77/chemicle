package com.chemcool.school.tasks.service.chemfixedanswer;

import com.chemcool.school.tasks.domain.chemfixedanswer.ChemFixedAnswerTask;
import com.chemcool.school.tasks.dto.chemfixedanswer.ChemFixedAnswerTaskCreateDto;
import com.chemcool.school.tasks.dto.chemfixedanswer.ChemFixedAnswerTaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChemFixedAnswerTaskPresentation {


    private final ChemFixedAnswerTaskServiceLayer serviceLayer;

    public List<ChemFixedAnswerTaskDto> getAllChemistryFixedAnswerDto(){
        return serviceLayer.getAllChemistryFixedAnswerDto();
    }

    public Optional<ChemFixedAnswerTask> getFixedAnswerTaskById(String id){
        return serviceLayer.getFixedAnswerTaskById(id);
    }

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

    public List<ChemFixedAnswerTaskDto> getAllChemFixedAnswerTaskByChapterIdDto(int chapterId) {
        return serviceLayer.getAllChemFixedAnswerTaskByChapterIdDto(chapterId);
    }

    public List<ChemFixedAnswerTaskDto> getAllChemFixedAnswerTaskByChapterIdAndReferenceIdDto(int chapterId, int referenceId) {
        return serviceLayer.getAllChemFixedAnswerTaskByChapterIdAndReferenceIdDto(chapterId, referenceId);
    }
}
