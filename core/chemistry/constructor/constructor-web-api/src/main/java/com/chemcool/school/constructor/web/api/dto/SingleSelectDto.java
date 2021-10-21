package com.chemcool.school.constructor.web.api.dto;

import com.chemcool.school.constructor.domain.representation.SingleSelectRepresentation;
import lombok.Data;

import java.util.List;

@Data
public class SingleSelectDto {
    private String conditionOfTask;
    private String rightAnswer;
    private List<String> answers;
    private Short classNum;
    private Short chapterNum;
    private Short paragraphNum;

    public static SingleSelectRepresentation build(SingleSelectDto dto) {
        SingleSelectRepresentation representation = SingleSelectRepresentation.builder()
                .conditionOfTask(dto.conditionOfTask)
                .rightAnswer(dto.rightAnswer)
                .answers(dto.answers)
                .classNum(dto.classNum)
                .chapterNum(dto.chapterNum)
                .paragraphNum(dto.paragraphNum)
                .build();
        return representation;
    }
}
