package com.chemcool.school.tasks.web.api.service;

import com.chemcool.school.tasks.domain.representation.FixedAnswerDtoRepresentation;
import com.chemcool.school.tasks.web.api.dto.FixedAnswerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FixedAnswerDtoConverter {

    public FixedAnswerDtoRepresentation convert(FixedAnswerDto fixedAnswerDto) {
        return  FixedAnswerDtoRepresentation.builder()
                .conditionOfTask(fixedAnswerDto.getConditionOfTask())
                .classNum(fixedAnswerDto.getClassNum())
                .chapterNum(fixedAnswerDto.getChapterNum())
                .paragraphNum(fixedAnswerDto.getParagraphNum())
                .answer(fixedAnswerDto.getAnswer())
                .build();
    }
}
