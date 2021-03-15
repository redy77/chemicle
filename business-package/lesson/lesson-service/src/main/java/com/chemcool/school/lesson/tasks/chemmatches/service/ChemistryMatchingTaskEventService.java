package com.chemcool.school.lesson.tasks.chemmatches.service;

import com.chemcool.school.lesson.tasks.chemmatches.domain.ChemistryMatchingTaskEvent;
import com.chemcool.school.lesson.tasks.chemmatches.storage.ChemistryMatchingTaskEventJournal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChemistryMatchingTaskEventService {

    private final ChemistryMatchingTaskEventJournal journal;

     public void handleEvent(ChemistryMatchingTaskEvent event) {
        journal.save(event);
    }
}
