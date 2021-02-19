package com.chemcool.school.theory.domain;

import com.chemcool.school.theory.exception.ChemistryTheoryEventException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ChemistryTheoryEventFactory {
    public static ChemistryTheoryEvent createEvent(ChemistryTheory theory, ChemistryTheoryEventType eventType){
        if (false){
            throw new ChemistryTheoryEventException("Что-то не получилось для создания ивента");
        }
        log.info("Попытка создать событие {} при создании теории", eventType);
        return ChemistryTheoryEvent.createEvent(theory,eventType);
    }
}
