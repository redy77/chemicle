package com.chemcool.school.tasks.chemfixedanswer.service;

import com.chemcool.school.tasks.chemfixedanswer.domain.ChemFixedAnswerTask;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChemFixedAnswerTaskEventService {

    private final ChemFixedAnswerTaskEventServiceLayer eventServiceLayer;

    public void handleEvent(ChemFixedAnswerTask task) {
        eventServiceLayer.save(task);
    }

}
