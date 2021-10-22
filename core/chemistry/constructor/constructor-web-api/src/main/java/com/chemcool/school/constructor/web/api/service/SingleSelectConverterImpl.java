package com.chemcool.school.constructor.web.api.service;

import com.chemcool.school.constructor.domain.representation.SingleSelectRepresentation;
import com.chemcool.school.constructor.web.api.dto.SingleSelectDto;
import org.springframework.stereotype.Service;

@Service
public class SingleSelectConverterImpl implements SingleSelectConverter{

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
