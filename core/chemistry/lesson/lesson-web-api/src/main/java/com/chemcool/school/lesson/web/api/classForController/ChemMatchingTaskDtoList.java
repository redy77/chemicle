package com.chemcool.school.lesson.web.api.classForController;

import com.chemcool.school.lesson.web.api.dto.ChemMatchingTaskDto;
import com.chemcool.school.lesson.web.api.service.ChemMatchingTaskPresentation;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class ChemMatchingTaskDtoList {
    private List<ChemMatchingTaskDto> chemMatchingTaskDtoList;

   public static ChemMatchingTaskDtoList getAllTask(ChemMatchingTaskPresentation presentation){
       ChemMatchingTaskDtoList chemMatchingTaskDtoList = new ChemMatchingTaskDtoList();
       chemMatchingTaskDtoList.setChemMatchingTaskDtoList(presentation.getAllTasksDto());
       return chemMatchingTaskDtoList;
   }

   public static ChemMatchingTaskDtoList getTaskByReference(
           ChemMatchingTaskPresentation presentation, Integer referenceId) {
       ChemMatchingTaskDtoList chemMatchingTaskDtoList = new ChemMatchingTaskDtoList();
       chemMatchingTaskDtoList.setChemMatchingTaskDtoList(presentation.getAllTasksByReferenceIdDto(referenceId));
       return chemMatchingTaskDtoList;
   }

   public static ChemMatchingTaskDtoList getTaskByChapter(
           ChemMatchingTaskPresentation presentation, Integer chapterId) {
       ChemMatchingTaskDtoList chemMatchingTaskDtoList = new ChemMatchingTaskDtoList();
       chemMatchingTaskDtoList.setChemMatchingTaskDtoList(presentation.getAllTasksByChapterIdDto(chapterId));
       return chemMatchingTaskDtoList;
   }

   public static ChemMatchingTaskDtoList getTaskByReferenceAndChapter(
           ChemMatchingTaskPresentation presentation, Integer referenceId, Integer chapterId
   ) {
       ChemMatchingTaskDtoList chemMatchingTaskDtoList = new ChemMatchingTaskDtoList();
       chemMatchingTaskDtoList.setChemMatchingTaskDtoList(presentation.getAllTasksByReferenceIdAndChapterIdDto(
               referenceId, chapterId));
       return chemMatchingTaskDtoList;
   }
}
