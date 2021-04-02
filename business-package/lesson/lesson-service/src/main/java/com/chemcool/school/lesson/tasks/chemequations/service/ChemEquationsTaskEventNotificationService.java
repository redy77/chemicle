package com.chemcool.school.lesson.tasks.chemequations.service;

import com.chemcool.school.lesson.tasks.chemequations.domain.ChemEquationsTaskEvent;


/**
 * Сервис уведомления о событии с соединениями
 *
 * @version 1.0
 * @autor Евгений Жиленков
 */
public interface ChemEquationsTaskEventNotificationService {
    void send(ChemEquationsTaskEvent event);
}
