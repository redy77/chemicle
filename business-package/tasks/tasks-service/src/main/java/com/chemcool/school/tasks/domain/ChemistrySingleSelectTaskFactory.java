package com.chemcool.school.tasks.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ChemistrySingleSelectTaskFactory {

    public static ChemistrySingleSelectTask  createTask(ChemistrySingleSelectTaskExample example) {
//        if (example.getLessonExampleChapter() < 1) { //todo добавить валидацию полей
//            throw new ChemistryLessonFormatException("Глава урока не может быть меньше 1.");
//        }
//        if (example.getLessonExampleReferences() < 1 || example.getLessonExampleReferences() > 4) {
//            throw new ChemistryLessonFormatException("Уровень химии не может быть меньше 1 или больше 4.");
//        }
        log.info("Попытка создать урок: " + "[" + example.getDescription() + "]");
        return ChemistrySingleSelectTask.createChemistrySingleSelectTask(example);
    }

}
