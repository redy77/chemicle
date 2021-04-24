package com.chemcool.school.tasks.chemequations.service;

import com.chemcool.school.tasks.chemequations.domain.ChemEquationsTaskEvent;


/**
 * Сервис уведомления о событии с соединениями
 *
 * @version 1.0
 * @autor Евгений Жиленков
 */
public interface ChemEquationsTaskEventNotificationService {
    void send(ChemEquationsTaskEvent event);
}
