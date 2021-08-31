package com.chemcool.school.lesson.web.api.classForController;

import com.chemcool.school.lesson.web.api.dto.ChemTheoryDto;
import com.chemcool.school.lesson.web.api.service.ChemTheoryPresentation;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class ChemTheoryDtoList {
    private List<ChemTheoryDto> chemTheoryDtoList;

    public static ChemTheoryDtoList getAllTheory(ChemTheoryPresentation presentation) {
        ChemTheoryDtoList theoryDtoList = new ChemTheoryDtoList();
        theoryDtoList.setChemTheoryDtoList(presentation.getAllTheoryDto());
        return theoryDtoList;
    }

    public static ChemTheoryDtoList getTheoryByReference(ChemTheoryPresentation presentation, Integer referenceId
    ) {
        ChemTheoryDtoList theoryDtoList = new ChemTheoryDtoList();
        theoryDtoList.setChemTheoryDtoList(presentation.getAllTheoryByReferenceIdDto(referenceId));
        return theoryDtoList;
    }

    public static ChemTheoryDtoList getTheoryByChapter(
            ChemTheoryPresentation presentation, Integer chapterId
    ) {
        ChemTheoryDtoList theoryDtoList = new ChemTheoryDtoList();
        theoryDtoList.setChemTheoryDtoList(presentation.getAllTheoryByChapterIdDto(chapterId));
        return theoryDtoList;
    }

    public static ChemTheoryDtoList getTaskByReferenceAndChapter(
            ChemTheoryPresentation presentation, Integer referenceId, Integer chapterId
    ) {
       ChemTheoryDtoList theoryDtoList = new ChemTheoryDtoList();
       theoryDtoList.setChemTheoryDtoList(presentation.getAllTheoryByReferenceIdAndChapterIdDto(
               referenceId, chapterId
       ));
       return theoryDtoList;
    }
}
