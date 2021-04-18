package com.chemcool.school.lesson.tasks.chemmatches.service;

import com.chemcool.school.lesson.tasks.chemmatches.domain.ChemMatchingTaskEvent;

public interface ChemMatchingTaskEventNotificationService {
    void send(ChemMatchingTaskEvent event);
}
