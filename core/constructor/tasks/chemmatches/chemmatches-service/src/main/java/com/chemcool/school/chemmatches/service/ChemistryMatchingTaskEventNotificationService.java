package com.chemcool.school.chemmatches.service;

import com.chemcool.school.chemmatches.domain.ChemistryMatchingTaskEvent;

public interface ChemistryMatchingTaskEventNotificationService {
    void send(ChemistryMatchingTaskEvent event);
}
