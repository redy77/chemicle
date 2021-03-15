package com.chemcool.school.lesson.tasks.chemsingleselect.service;


import com.chemcool.school.lesson.tasks.chemsingleselect.domain.ChemSingleSelectTaskEvent;

public interface ChemSingleSelectTaskEventNotificationService {
    void send(ChemSingleSelectTaskEvent event);
}
