package com.chemcool.school.lesson.service;

import com.chemcool.school.lesson.domain.ChemistryLessonEvent;
import com.chemcool.school.lesson.storage.ChemistryLessonEventJournal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChemistryLessonEventService{
    private final ChemistryLessonEventJournal journal;

    public void handleEvent(ChemistryLessonEvent event){
        journal.save(event);
    }
}
