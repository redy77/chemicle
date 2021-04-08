package com.chemcool.school.lesson.tasks.chemfixedanswer.service;

import com.chemcool.school.lesson.tasks.chemfixedanswer.domain.ChemFixedAnswerTaskEvent;

public interface ChemFixedAnswerTaskEventNotificationService {
    void send(ChemFixedAnswerTaskEvent event);
}
