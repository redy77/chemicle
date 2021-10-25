package com.chemcool.school.tasks.domain.representation;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FixedAnswerDtoRepresentation {


    private String conditionOfTask;

    private Short classNum;

    private Short chapterNum;

    private Short paragraphNum;

    private String answer;
}
