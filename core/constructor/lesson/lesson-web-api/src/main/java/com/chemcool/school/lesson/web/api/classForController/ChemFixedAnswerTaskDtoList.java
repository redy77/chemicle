package com.chemcool.school.lesson.web.api.classForController;

import com.chemcool.school.lesson.web.api.dto.ChemFixedAnswerTaskDto;
import com.chemcool.school.lesson.web.api.service.ChemFixedAnswerTaskPresentation;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class ChemFixedAnswerTaskDtoList {
    private List<ChemFixedAnswerTaskDto> chemFixedAnswerTaskDtoList;

    public static ChemFixedAnswerTaskDtoList getAllTask(ChemFixedAnswerTaskPresentation presentation) {
        ChemFixedAnswerTaskDtoList controller = new ChemFixedAnswerTaskDtoList();
        controller.setChemFixedAnswerTaskDtoList(presentation.getAllChemistryFixedAnswerDto());
        return controller;
    }

    public static ChemFixedAnswerTaskDtoList getTaskByReference(ChemFixedAnswerTaskPresentation presentation, Integer referenceId) {
        ChemFixedAnswerTaskDtoList controller = new ChemFixedAnswerTaskDtoList();
        controller.setChemFixedAnswerTaskDtoList(presentation.getAllChemistryFixedAnswerByReferenceIdDto(referenceId));
        return controller;
    }

    public static ChemFixedAnswerTaskDtoList getTaskByChapter(ChemFixedAnswerTaskPresentation presentation, Integer chapterId) {
        ChemFixedAnswerTaskDtoList controller = new ChemFixedAnswerTaskDtoList();
        controller.setChemFixedAnswerTaskDtoList(presentation.getAllChemistryFixedAnswerByChapterIdDto(chapterId));
        return controller;
    }

    public static ChemFixedAnswerTaskDtoList getTaskByReferenceAndChapter(
            ChemFixedAnswerTaskPresentation presentation,
            Integer referenceId, Integer chapterId) {
        ChemFixedAnswerTaskDtoList controller = new ChemFixedAnswerTaskDtoList();
        controller.setChemFixedAnswerTaskDtoList(presentation.getAllChemistryFixedAnswerByReferenceIdAndChapterIdDto(
                referenceId,
                chapterId));
        return controller;
    }
}
