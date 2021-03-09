package com.chemcool.school.lesson.theory.service;


import com.chemcool.school.lesson.theory.domain.ChemistryTheoryEvent;

public interface ChemistryTheoryEventNotificationService {
    void send(ChemistryTheoryEvent event);
}
