package com.chemcool.school.constructor.web.api.service.impls;
/**
 * @Author Constantine Lee
 */

import com.chemcool.school.constructor.domain.representation.SingleSelectRepresentation;
import com.chemcool.school.constructor.web.api.dto.SingleSelectDto;
import com.chemcool.school.constructor.web.api.service.SingleSelectDtoConverter;
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
