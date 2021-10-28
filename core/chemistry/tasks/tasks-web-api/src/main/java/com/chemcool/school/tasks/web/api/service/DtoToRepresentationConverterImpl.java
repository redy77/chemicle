package com.chemcool.school.tasks.web.api.service;

import com.chemcool.school.tasks.domain.representations.SingleSelectRepresentation;
import com.chemcool.school.tasks.web.api.dto.SingleSelectDto;
import org.springframework.stereotype.Service;

/**
 * @Author : Constantine Lee
 * @Date : 28.10.2021
 * @e-mail : rhowbn@gmail.com
 */
@Service
public class DtoToRepresentationConverterImpl implements DtoToRepresentationConverter{
    public SingleSelectRepresentation toRepresentation(SingleSelectDto dto) {
        return SingleSelectRepresentation.builder()
                .taskId(dto.getTaskId())
                .conditionOfTask(dto.getConditionOfTask())
                .rightAnswer(dto.getRightAnswer())
                .answers(dto.getAnswers())
                .classNum(dto.getClassNum())
                .chapterNum(dto.getChapterNum())
                .paragraphNum(dto.getParagraphNum())
                .build();
    }
}
