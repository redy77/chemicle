package com.chemcool.school.lesson.service;

import com.chemcool.school.lesson.domain.ChemistryLessonEvent;

public interface ChemistryLessonEventNotificationService {
    void send(ChemistryLessonEvent event);
}
