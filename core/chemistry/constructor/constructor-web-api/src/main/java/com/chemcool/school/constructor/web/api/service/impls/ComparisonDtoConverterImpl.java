package com.chemcool.school.constructor.web.api.service.impls;

import com.chemcool.school.constructor.domain.representation.ComparisonPresentation;
import com.chemcool.school.constructor.web.api.dto.ComparisonDto;
import com.chemcool.school.constructor.web.api.service.ComparisonDtoConverter;
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
