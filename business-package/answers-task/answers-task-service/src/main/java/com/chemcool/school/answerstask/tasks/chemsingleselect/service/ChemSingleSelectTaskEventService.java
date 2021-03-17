package com.chemcool.school.answerstask.tasks.chemsingleselect.service;

import com.chemcool.school.answerstask.tasks.chemsingleselect.domain.ChemSingleSelectTaskEvent;
import com.chemcool.school.answerstask.tasks.chemsingleselect.storage.ChemSingleSelectTaskEventJournal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChemSingleSelectTaskEventService {

    private final ChemSingleSelectTaskEventJournal journal;

     public void handleEvent(ChemSingleSelectTaskEvent event) {
        journal.save(event);
    }
}
