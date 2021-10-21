package com.chemcool.school.constructor.web.api.service;

import com.chemcool.school.constructor.presentation.ComparisonPresentation;
import com.chemcool.school.constructor.web.api.dto.ComparisonDto;
import org.springframework.stereotype.Component;

@Component
public class ComparisonDtoConverter {

    public ComparisonPresentation convertComparisonDtoToPresentation(ComparisonDto comparisonDto) {
        return ComparisonPresentation
                .builder()
                .conditionOfTask(comparisonDto.getConditionOfTask())
                .classNum(comparisonDto.getClassNum())
                .chapterNum(comparisonDto.getChapterNum())
                .paragraphNum(comparisonDto.getParagraphNum())
                .correctAnswers(comparisonDto.getCorrectAnswers())
                .build();
    }
}
