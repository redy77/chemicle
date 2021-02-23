package com.chemcool.school.tasks.chemequations.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ChemCompoundEventFactory {
    public static ChemCompoundEvent createTaskEvent(ChemCompound compound, ChemCompoundEventType eventType){
        log.info("Попытка создать событие");
        return ChemCompoundEvent.createEvent(compound, eventType);
    }
}
