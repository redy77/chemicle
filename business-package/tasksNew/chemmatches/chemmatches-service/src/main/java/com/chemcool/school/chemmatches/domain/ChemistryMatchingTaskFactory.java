package com.chemcool.school.chemmatches.domain;

import com.chemcool.school.chemmatches.exception.ChemistryMatchingTaskException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ChemistryMatchingTaskFactory {

    public static ChemistryMatchingTask createTask(ChemistryMatchingTaskExample chemistryMatchingTaskExample) {
        if (chemistryMatchingTaskExample.getChapterId() < 1) {
            throw new ChemistryMatchingTaskException("Глава урока не может быть меньше 1.");
        }

      log.info("Попытка создать задачу с сопоставлением");
        return ChemistryMatchingTask.createChemistryMatchingTask(chemistryMatchingTaskExample);
    }

}
