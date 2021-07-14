package com.chemcool.school.lesson.service.theory;


import com.chemcool.school.lesson.domain.theory.ChemTheoryEvent;
import com.chemcool.school.lesson.storage.theory.ChemTheoryEventJournal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class ChemTheoryEventService {

    private final ChemTheoryEventJournal journal;

    public void handleEvent(ChemTheoryEvent event){
        journal.save(event);
    }
}
