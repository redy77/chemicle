package com.chemcool.school.theory.web.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LessonExample {
    private String lessonExampleName;
    private String lessonExampleDescription;
    private String lessonExampleChapter;
    private String lessonExampleReferences;
}
