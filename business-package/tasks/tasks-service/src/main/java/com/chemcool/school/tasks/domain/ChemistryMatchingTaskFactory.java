package com.chemcool.school.tasks.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ChemistryMatchingTaskFactory {
    public static ChemistryMatchingTask createTask(ChemistryMatchingTaskExample example) {
        log.info("Попытка создать урок: " + "[" + example.getDescription() + "]");
        return ChemistryMatchingTask.createChemistryMatchingTask(example);
    }
}
