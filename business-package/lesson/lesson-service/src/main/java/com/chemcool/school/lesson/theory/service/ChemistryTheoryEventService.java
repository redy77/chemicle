package com.chemcool.school.lesson.theory.service;


import com.chemcool.school.lesson.theory.domain.ChemistryTheoryEvent;
import com.chemcool.school.lesson.theory.storage.ChemistryTheoryEventJournal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class ChemistryTheoryEventService {

    private final ChemistryTheoryEventJournal journal;

    public void handleEvent(ChemistryTheoryEvent event){
        journal.save(event);
    }
}
