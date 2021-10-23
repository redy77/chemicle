package com.chemcool.school.constructor.representation;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FixedAnswerDtoRepresentation {

    @NotBlank
    private String conditionOfTask;

    @NotBlank
    private Short classNum;

    @NotBlank
    private Short chapterNum;

    @NotBlank
    private Short paragraphNum;

    @NotBlank
    private String answer;

    @NotBlank
    private String idAuthor;

}
