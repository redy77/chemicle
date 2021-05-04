package com.chemcool.school.tasks.chemmatches.service;

import com.chemcool.school.tasks.chemmatches.domain.ChemistryMatchingTaskEvent;

public interface ChemistryMatchingTaskEventNotificationService {
    void send(ChemistryMatchingTaskEvent event);
}
