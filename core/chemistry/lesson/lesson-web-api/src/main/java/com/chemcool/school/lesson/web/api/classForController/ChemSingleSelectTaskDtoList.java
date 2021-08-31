package com.chemcool.school.lesson.web.api.classForController;

import com.chemcool.school.lesson.web.api.dto.ChemSingleSelectTaskDto;
import com.chemcool.school.lesson.web.api.service.ChemSingleSelectTaskPresentation;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class ChemSingleSelectTaskDtoList {
    private List<ChemSingleSelectTaskDto> chemSingleSelectTaskDtoList;

    public static ChemSingleSelectTaskDtoList getAllTask(ChemSingleSelectTaskPresentation presentation) {
        ChemSingleSelectTaskDtoList taskDtoList = new ChemSingleSelectTaskDtoList();
        taskDtoList.setChemSingleSelectTaskDtoList(presentation.getAllTasksDto());
        return taskDtoList;
    }

    public static ChemSingleSelectTaskDtoList getTaskByReference(
            ChemSingleSelectTaskPresentation presentation, Integer referenceId) {
        ChemSingleSelectTaskDtoList taskDtoList = new ChemSingleSelectTaskDtoList();
        taskDtoList.setChemSingleSelectTaskDtoList(presentation.getAllTasksByReferenceIdDto(referenceId));
        return taskDtoList;
    }

    public static ChemSingleSelectTaskDtoList getTaskByChapter(
            ChemSingleSelectTaskPresentation presentation, Integer chapterId
    ) {
        ChemSingleSelectTaskDtoList taskDtoList = new ChemSingleSelectTaskDtoList();
        taskDtoList.setChemSingleSelectTaskDtoList(presentation.getAllTasksByChapterIdDto(chapterId));
        return taskDtoList;
    }

    public static ChemSingleSelectTaskDtoList getTaskByReferenceAndChapter(
            ChemSingleSelectTaskPresentation presentation, Integer referenceId, Integer chapterId
    ) {
        ChemSingleSelectTaskDtoList taskDtoList = new ChemSingleSelectTaskDtoList();
        taskDtoList.setChemSingleSelectTaskDtoList(presentation.getAllTasksByReferenceIdAndChapterIdDto(
                referenceId, chapterId));
        return taskDtoList;
    }
}
