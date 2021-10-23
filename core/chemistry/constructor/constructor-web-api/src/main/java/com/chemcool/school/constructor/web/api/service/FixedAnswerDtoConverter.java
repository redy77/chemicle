package com.chemcool.school.constructor.web.api.service;

import com.chemcool.school.constructor.domain.representation.FixedAnswerDtoRepresentation;
import com.chemcool.school.constructor.web.api.dto.FixedAnswerDto;
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
                .idAuthor(fixedAnswerDto.getIdAuthor())
                .build();
    }
}
