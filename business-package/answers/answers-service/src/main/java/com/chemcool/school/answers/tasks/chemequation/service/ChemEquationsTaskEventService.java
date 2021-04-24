package com.chemcool.school.answers.tasks.chemequation.service;

import com.chemcool.school.answers.tasks.chemequation.domain.ChemEquationsTaskEvent;
import com.chemcool.school.answers.tasks.chemequation.storage.ChemEquationsTaskEventJournal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChemEquationsTaskEventService {

    private final ChemEquationsTaskEventJournal eventJournal;

    public void handleEvent(ChemEquationsTaskEvent event) {
        eventJournal.save(event);
        log.info("Событие отправлено на сохранение");
    }
}