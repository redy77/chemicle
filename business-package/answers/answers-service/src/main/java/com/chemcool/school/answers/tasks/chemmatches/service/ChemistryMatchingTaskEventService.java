package com.chemcool.school.answers.tasks.chemmatches.service;

import com.chemcool.school.answers.tasks.chemmatches.storage.ChemistryMatchingTaskEventJournal;
import com.chemcool.school.answers.tasks.chemmatches.domain.ChemistryMatchingTaskEvent;
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
