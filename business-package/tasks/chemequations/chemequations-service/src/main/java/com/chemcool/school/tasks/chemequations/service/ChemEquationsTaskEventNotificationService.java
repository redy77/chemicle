package com.chemcool.school.tasks.chemequations.service;

import com.chemcool.school.tasks.chemequations.domain.ChemEquationsTaskEvent;

public interface ChemEquationsTaskEventNotificationService {
    void send(ChemEquationsTaskEvent event);
}
