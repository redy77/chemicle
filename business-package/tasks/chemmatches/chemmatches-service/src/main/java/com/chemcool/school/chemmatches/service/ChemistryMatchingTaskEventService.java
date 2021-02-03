package com.chemcool.school.chemmatches.service;

import com.chemcool.school.chemmatches.domain.ChemistryMatchingTaskEvent;
import com.chemcool.school.chemmatches.storage.ChemistryMatchingTaskEventJournal;
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
