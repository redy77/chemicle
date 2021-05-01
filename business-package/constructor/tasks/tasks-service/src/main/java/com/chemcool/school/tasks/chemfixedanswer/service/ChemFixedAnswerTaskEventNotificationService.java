package com.chemcool.school.tasks.chemfixedanswer.service;

import com.chemcool.school.tasks.chemfixedanswer.domain.ChemFixedAnswerTaskEvent;

public interface ChemFixedAnswerTaskEventNotificationService {
    void send(ChemFixedAnswerTaskEvent event);
}
