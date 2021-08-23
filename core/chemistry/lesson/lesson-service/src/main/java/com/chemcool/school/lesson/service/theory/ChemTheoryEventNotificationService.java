package com.chemcool.school.lesson.service.theory;


import com.chemcool.school.lesson.domain.theory.ChemTheoryEvent;

public interface ChemTheoryEventNotificationService {
    void send(ChemTheoryEvent event);
}
