package com.chemcool.school.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChemistryLessonExample {
    private String lessonExampleName;
    private String lessonExampleDescription;
    private String lessonExampleChapter;
    private String lessonExampleReferences;
}
