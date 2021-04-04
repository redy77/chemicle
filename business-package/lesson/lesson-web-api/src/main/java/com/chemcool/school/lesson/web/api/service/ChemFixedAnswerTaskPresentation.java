package com.chemcool.school.lesson.web.api.service;

import com.chemcool.school.lesson.tasks.chemfixedanswer.domain.ChemFixedAnswerTask;
import com.chemcool.school.lesson.web.api.dto.ChemFixedAnswerTaskDto;
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

    public  List<ChemFixedAnswerTaskDto> getAllChemistryFixedAnswerByReferenceIdDto(int referenceId){
        return serviceLayer.getAllChemistryFixedAnswerByReferenceIdDto(referenceId);
    }

    public  List<ChemFixedAnswerTaskDto> getAllChemistryFixedAnswerByChapterIdDto(int chapterId){
        return serviceLayer.getAllChemistryFixedAnswerByChapterIdDto(chapterId);
    }

    public  List<ChemFixedAnswerTaskDto> getAllChemistryFixedAnswerByReferenceIdAndChapterIdDto(int referenceId, int chapterId){
        return serviceLayer.getAllChemistryFixedAnswerByReferenceIdAndChapterIdDto(referenceId, chapterId);
    }
}
