package com.chemcool.school.lesson.tasks.chemequations.service;

import com.chemcool.school.lesson.tasks.chemequations.domain.ChemEquationsTaskEvent;
import com.chemcool.school.lesson.tasks.chemequations.storage.ChemEquationsTaskEventJournal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChemEquationsTaskEventService {

    private final ChemEquationsTaskEventJournal journal;

    public void handleEvent(ChemEquationsTaskEvent event) {
        journal.save(event);
        log.info("Событие отправлено на сохранение");
    }
}