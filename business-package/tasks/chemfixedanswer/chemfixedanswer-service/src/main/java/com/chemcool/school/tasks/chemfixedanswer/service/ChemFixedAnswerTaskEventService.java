package com.chemcool.school.tasks.chemfixedanswer.service;

import com.chemcool.school.tasks.chemfixedanswer.domain.ChemFixedAnswerTask;
import com.chemcool.school.tasks.chemfixedanswer.domain.ChemFixedAnswerTaskEvent;
import com.chemcool.school.tasks.chemfixedanswer.storage.ChemFixedAnswerTaskEventJournal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChemFixedAnswerTaskEventService {

    private final ChemFixedAnswerTaskEventJournal eventJournal;

    public void handleEvent(ChemFixedAnswerTaskEvent task) {
        eventJournal.save(task);
    }

}
