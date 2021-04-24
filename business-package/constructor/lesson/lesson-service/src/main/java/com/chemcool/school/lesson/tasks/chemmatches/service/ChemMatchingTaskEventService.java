package com.chemcool.school.lesson.tasks.chemmatches.service;

import com.chemcool.school.lesson.tasks.chemmatches.domain.ChemMatchingTaskEvent;
import com.chemcool.school.lesson.tasks.chemmatches.storage.ChemMatchingTaskEventJournal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChemMatchingTaskEventService {

    private final ChemMatchingTaskEventJournal journal;

     public void handleEvent(ChemMatchingTaskEvent event) {
        journal.save(event);
    }
}
