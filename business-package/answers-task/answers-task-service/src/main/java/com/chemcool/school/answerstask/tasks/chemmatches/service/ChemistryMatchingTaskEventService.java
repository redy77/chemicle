package com.chemcool.school.answerstask.tasks.chemmatches.service;

import com.chemcool.school.answerstask.tasks.chemmatches.storage.ChemistryMatchingTaskEventJournal;
import com.chemcool.school.answerstask.tasks.chemmatches.domain.ChemistryMatchingTaskEvent;
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
