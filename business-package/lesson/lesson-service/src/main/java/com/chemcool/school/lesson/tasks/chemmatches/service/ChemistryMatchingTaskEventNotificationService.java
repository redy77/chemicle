package com.chemcool.school.lesson.tasks.chemmatches.service;

import com.chemcool.school.lesson.tasks.chemmatches.domain.ChemistryMatchingTaskEvent;

public interface ChemistryMatchingTaskEventNotificationService {
    void send(ChemistryMatchingTaskEvent event);
}
