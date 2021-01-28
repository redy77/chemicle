package com.chemcool.school.chemmatches.domain;

import com.chemcool.school.chemmatches.TypeOfTask;
import com.chemcool.school.chemmatches.exception.ChemistryChemistryMatchingTaskException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ChemistryMatchingTaskFactory {

    public static ChemistryMatchingTask createChemistryMatchingTask(ChemistryMatchingTaskExample chemistryMatchingTaskExample) {
        if (Integer.parseInt(chemistryMatchingTaskExample.getChapterId()) < 1) {
            throw new ChemistryChemistryMatchingTaskException("Глава урока не может быть меньше 1.");
        }
        if (!(chemistryMatchingTaskExample.getTypeOfTask() == TypeOfTask.CHEMISTRY_EQUATION) && !(chemistryMatchingTaskExample.getTypeOfTask() == TypeOfTask.FIXED_ANSWER)
        && !(chemistryMatchingTaskExample.getTypeOfTask() == TypeOfTask.MATCHING) && !(chemistryMatchingTaskExample.getTypeOfTask() == TypeOfTask.SINGLE_SELECT)) {
            throw new ChemistryChemistryMatchingTaskException("Тип задания не соответствует существубщим.");
        }
        log.info("Попытка создать задачу с сопоставлением" + chemistryMatchingTaskExample.getTypeOfTask());
        return ChemistryMatchingTask.createChemistryMatchingTask(chemistryMatchingTaskExample);
    }

}
