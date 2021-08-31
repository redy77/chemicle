package com.chemcool.school.lesson.service.equation;

import com.chemcool.school.lesson.domain.equation.ChemEquationsTaskEvent;

public interface ChemEquationsTaskEventNotificationService {
    void send(ChemEquationsTaskEvent event);
}
