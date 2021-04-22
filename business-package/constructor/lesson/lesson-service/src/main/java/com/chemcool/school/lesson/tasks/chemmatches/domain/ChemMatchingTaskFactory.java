package com.chemcool.school.lesson.tasks.chemmatches.domain;

import com.chemcool.school.lesson.tasks.chemmatches.exception.ChemMatchingTaskException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ChemMatchingTaskFactory {

    public static ChemMatchingTask createTask(ChemMatchingTaskExample chemMatchingTaskExample) {
        if (chemMatchingTaskExample.getChapterId() < 1) {
            throw new ChemMatchingTaskException("Глава урока не может быть меньше 1.");
        }

      log.info("Попытка создать задачу с сопоставлением");
        return ChemMatchingTask.createChemistryMatchingTask(chemMatchingTaskExample);
    }

}
