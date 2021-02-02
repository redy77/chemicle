package com.chemcool.school.theory.domain;

import com.chemcool.school.theory.exception.ChemistryTheoryFormatException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ChemistryTheoryFactory {

    public static ChemistryTheory createLesson(ChemistryTheoryExample example) {
        if (example.getLessonExampleChapter() < 1) {
            throw new ChemistryTheoryFormatException("Глава урока не может быть меньше 1.");
        }
        if (example.getLessonExampleReferences() < 1 || example.getLessonExampleReferences() > 4) {
            throw new ChemistryTheoryFormatException("Уровень химии не может быть меньше 1 или больше 4.");
        }
        log.info("Попытка создать урок: " + "[" + example.getLessonExampleName() + "]");
        return ChemistryTheory.createChemistryLesson(example);
    }

}
