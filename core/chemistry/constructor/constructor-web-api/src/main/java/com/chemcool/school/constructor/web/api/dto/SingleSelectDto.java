package com.chemcool.school.constructor.web.api.dto;
/**
 * @Author Constantine Lee
 */

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
}
