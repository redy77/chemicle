package com.chemcool.school.tasks.service.chemequations;


import com.chemcool.school.tasks.domain.chemequations.ChemEquationsTaskEvent;

public interface ChemEquationsTaskEventNotificationService {
    void send(ChemEquationsTaskEvent event);
}
