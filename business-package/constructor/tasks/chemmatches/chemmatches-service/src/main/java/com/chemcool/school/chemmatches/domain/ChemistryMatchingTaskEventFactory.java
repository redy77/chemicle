package com.chemcool.school.chemmatches.domain;

import com.chemcool.school.chemmatches.exception.ChemistryMatchingTaskException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ChemistryMatchingTaskEventFactory {

    public static ChemistryMatchingTaskEvent createEvent(ChemistryMatchingTask task, ChemistryMatchingTaskEventType eventType){

        if (false) {
            //todo реализовать логику для фабрики события создания таски
            throw new ChemistryMatchingTaskException("Что-то не получилось для создания ивента");
        }
        log.info("Попытка создать событие {} при создании таски с СОПОСТАВЛЕНИЕМ", eventType);
        return ChemistryMatchingTaskEvent.createEvent(task, "777", eventType);
    }
}