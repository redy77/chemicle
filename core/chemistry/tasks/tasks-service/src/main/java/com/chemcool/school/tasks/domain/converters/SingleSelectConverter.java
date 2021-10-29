package com.chemcool.school.tasks.domain.converters;

import com.chemcool.school.tasks.domain.SingleSelectTask;
import com.chemcool.school.tasks.domain.dto.SingleSelectDTO;
import org.springframework.stereotype.Component;

/**
 * @Author : Constantine Lee
 * @Date : 27.10.2021
 * @e-mail : rhowbn@gmail.com
 */
@Component("singleSelect")
public class SingleSelectConverter implements DTOConverter<SingleSelectTask, SingleSelectDTO> {

    @Override
    public SingleSelectDTO taskToDto(SingleSelectTask task) {
        return SingleSelectDTO.builder()
                .taskId(task.getTaskId())
                .conditionOfTask(task.getConditionOfTask())
                .classNum(task.getClassNum())
                .chapterNum(task.getChapterNum())
                .paragraphNum(task.getParagraphNum())
                .rightAnswer(task.getRightAnswer())
                .answers(task.getAnswers())
                .build();
    }

    @Override
    public SingleSelectTask dtoToTask(SingleSelectDTO dto) {
        return SingleSelectTask.builder()
                .taskId(dto.getTaskId())
                .conditionOfTask(dto.getConditionOfTask())
                .classNum(dto.getClassNum())
                .chapterNum(dto.getChapterNum())
                .paragraphNum(dto.getParagraphNum())
                .rightAnswer(dto.getRightAnswer())
                .answers(dto.getAnswers())
                .build();
    }
}
