package com.chemcool.school.lesson.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChemistryLessonExample {
    private String lessonExampleName;
    private String lessonExampleDescription;
    private Integer lessonExampleChapter;
    private Integer lessonExampleReferences;

    public static ChemistryLessonExample fromLessonExample(
            String name,
            String description,
            Integer chapter,
            Integer references
    ){
        return new ChemistryLessonExample(
                name,
                description,
                chapter,
                references
        );
    }
}
