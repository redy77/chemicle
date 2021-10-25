package com.chemcool.school.tasks.web.api.service;
/**
 * @Author Constantine Lee
 */

import com.chemcool.school.tasks.domain.representation.SingleSelectRepresentation;
import com.chemcool.school.tasks.web.api.dto.SingleSelectDto;
import org.springframework.stereotype.Service;

@Service
public class SingleSelectDtoConverterImpl implements SingleSelectDtoConverter {

    public SingleSelectRepresentation convertToRepresentation(SingleSelectDto dto) {

        return SingleSelectRepresentation.builder()
                .conditionOfTask(dto.getConditionOfTask())
                .rightAnswer(dto.getRightAnswer())
                .answers(dto.getAnswers())
                .classNum(dto.getClassNum())
                .chapterNum(dto.getChapterNum())
                .paragraphNum(dto.getParagraphNum())
                .build();
    }
}
