package com.chemcool.school.constructor.domain.representation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TheoryTaskRepresentation {
    private String conditionOfTask;
    private Short classNum;
    private Short chapterNum;
    private Short paragraphNum;
    private String theoryText;
}
