package com.chemcool.school.lesson.domain;

import com.chemcool.school.lesson.exception.ChemistryLessonFormatException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ChemistryLessonFactory {

    public static ChemistryLesson createLesson(ChemistryLessonExample example){
        if (example.getLessonExampleChapter() < 1){
            throw new ChemistryLessonFormatException("Глава урока не может быть меньше 1.");
        }
        if (example.getLessonExampleReferences()<1 || example.getLessonExampleReferences() > 4){
            throw new ChemistryLessonFormatException("Уровень химии не может быть меньше 1 или больше 4.");
        }
        log.info("Попытка создать урок: " + "[" + example.getLessonExampleName() + "]");
        return ChemistryLesson.createChemistryLesson(example);
    }
}
