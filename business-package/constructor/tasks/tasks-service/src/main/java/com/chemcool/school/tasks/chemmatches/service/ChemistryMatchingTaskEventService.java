package com.chemcool.school.tasks.chemmatches.service;

import com.chemcool.school.tasks.chemmatches.domain.ChemistryMatchingTaskEvent;
import com.chemcool.school.tasks.chemmatches.infrastructure.storage.ChemistryMatchingTaskEventJournal;
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
