package com.chemcool.school.lesson.web.api.classForController;

import com.chemcool.school.lesson.web.api.dto.ChemEquationsTaskDto;
import com.chemcool.school.lesson.web.api.service.ChemEquationsTaskPresentation;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class ChemEquationsTaskDtoList {
    private List<ChemEquationsTaskDto> equationsTaskDtoList;

    public static ChemEquationsTaskDtoList getAllTask(ChemEquationsTaskPresentation presentation) {
        ChemEquationsTaskDtoList controller = new ChemEquationsTaskDtoList();
        controller.setEquationsTaskDtoList(presentation.getAllChemistryEquationsDto());
        return controller;
    }

    public static ChemEquationsTaskDtoList getTaskByReference(ChemEquationsTaskPresentation presentation, Integer referenceId) {
        ChemEquationsTaskDtoList controller = new ChemEquationsTaskDtoList();
        controller.setEquationsTaskDtoList(presentation.getAllChemistryEquationsByReferenceIdDto(referenceId));
        return controller;
    }

    public static ChemEquationsTaskDtoList getTaskByChapter(ChemEquationsTaskPresentation presentation, Integer chapterId) {
        ChemEquationsTaskDtoList controller = new ChemEquationsTaskDtoList();
        controller.setEquationsTaskDtoList(presentation.getAllChemistryEquationsByChapterIdDto(chapterId));
        return controller;
    }

    public static ChemEquationsTaskDtoList getTaskByReferenceAndChapter(
            ChemEquationsTaskPresentation presentation,
            Integer referenceId, Integer chapterId) {
        ChemEquationsTaskDtoList controller = new ChemEquationsTaskDtoList();
        controller.setEquationsTaskDtoList(presentation.getAllChemistryEquationsByReferenceIdAndChapterIdDto(referenceId, chapterId));
        return controller;
    }

}
