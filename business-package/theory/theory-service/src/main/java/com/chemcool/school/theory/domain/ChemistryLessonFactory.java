package com.chemcool.school.theory.domain;

import org.springframework.stereotype.Component;

@Component
public class ChemistryLessonFactory {

    public static ChemistryLesson  createLesson(ChemistryLessonExample example) {
        return ChemistryLesson.createChemistryLesson(example);
    }

}
