package com.chemcool.school.tasks.web.api.service;

import com.chemcool.school.tasks.domain.representation.ComparisonPresentation;
import com.chemcool.school.tasks.web.api.dto.ComparisonDto;
import org.springframework.stereotype.Component;

@Component
public class ComparisonDtoConverterImpl implements ComparisonDtoConverter {

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
