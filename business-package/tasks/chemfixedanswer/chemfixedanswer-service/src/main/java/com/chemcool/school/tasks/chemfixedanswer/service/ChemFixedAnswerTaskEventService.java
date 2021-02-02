package com.chemcool.school.tasks.chemfixedanswer.service;

import com.chemcool.school.tasks.chemfixedanswer.domain.ChemFixedAnswerTask;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChemFixedAnswerTaskEventService {

    private final ChemFixedAnswerTaskEventSlaveLayer eventSlaveLayer;

    public void save(ChemFixedAnswerTask task) {
        eventSlaveLayer.save(task);
    }

    public void update(ChemFixedAnswerTask task) {
        eventSlaveLayer.update(task);
    }
}
