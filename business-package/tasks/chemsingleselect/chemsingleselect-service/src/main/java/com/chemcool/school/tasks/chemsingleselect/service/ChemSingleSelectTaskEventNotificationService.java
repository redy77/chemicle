package com.chemcool.school.tasks.chemsingleselect.service;

import com.chemcool.school.tasks.chemsingleselect.domain.ChemSingleSelectTaskEvent;

public interface ChemSingleSelectTaskEventNotificationService {
    void send(ChemSingleSelectTaskEvent event);
}
