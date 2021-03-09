package com.chemcool.school.lesson.domain;

import com.chemcool.school.lesson.exception.ChemistryLessonEventException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ChemistryLessonEventFactory {
    public static ChemistryLessonEvent createEvent(ChemistryLesson lesson,ChemistryLessonEventType eventType){
        if (false){
            throw new ChemistryLessonEventException("Что-то не получилось для создания ивента");
        }
        log.info("Попытка создать событие {} при создании теории", eventType);
        return ChemistryLessonEvent.createEvent(lesson,eventType);
    }
}
