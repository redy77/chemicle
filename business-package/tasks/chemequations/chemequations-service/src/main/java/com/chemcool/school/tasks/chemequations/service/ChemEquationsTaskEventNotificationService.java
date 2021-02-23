package com.chemcool.school.tasks.chemequations.service;

import com.chemcool.school.tasks.chemequations.domain.ChemCompoundEvent;

public interface ChemEquationsTaskEventNotificationService {
    void send(ChemCompoundEvent event);
}
