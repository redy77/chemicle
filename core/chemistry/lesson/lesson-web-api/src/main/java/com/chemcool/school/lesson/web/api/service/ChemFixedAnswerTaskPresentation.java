package com.chemcool.school.lesson.web.api.service;

import com.chemcool.school.lesson.web.api.dto.ChemFixedAnswerTaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChemFixedAnswerTaskPresentation {


    private final ChemFixedAnswerTaskServiceLayer serviceLayer;

    public List<ChemFixedAnswerTaskDto> getAllChemistryFixedAnswerDto(){
        return serviceLayer.getAllChemistryFixedAnswerDto();
    }

    public ChemFixedAnswerTaskDto getFixedAnswerTaskById(String id){
        return serviceLayer.getFixedAnswerTaskById(id);
    }

    public  List<ChemFixedAnswerTaskDto> getAllChemistryFixedAnswerByReferenceIdDto(Integer referenceId){
        return serviceLayer.getAllChemistryFixedAnswerByReferenceIdDto(referenceId);
    }

    public  List<ChemFixedAnswerTaskDto> getAllChemistryFixedAnswerByChapterIdDto(Integer chapterId){
        return serviceLayer.getAllChemistryFixedAnswerByChapterIdDto(chapterId);
    }

    public  List<ChemFixedAnswerTaskDto> getAllChemistryFixedAnswerByReferenceIdAndChapterIdDto(Integer referenceId,
                                                                                                Integer chapterId){
        return serviceLayer.getAllChemistryFixedAnswerByReferenceIdAndChapterIdDto(referenceId, chapterId);
    }

    public ChemFixedAnswerTaskDto getRandomChemFixedAnswerTaskDto() {
        return serviceLayer.getRandomChemFixedAnswerTaskDto();
    }
}
