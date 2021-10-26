package com.chemcool.school.constructor.domain.representation;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @Author : Constantine Lee
 * @Date : 26.10.2021
 * @e-mail : rhowbn@gmail.com
 */
@Data
@Builder
public class TheoryTaskRepresentation {
    private String conditionOfTask;
    private Short classNum;
    private Short chapterNum;
    private Short paragraphNum;
    private String theoryText;
}
