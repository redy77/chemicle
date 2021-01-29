package com.chemcool.school.tasks.chemsingleselect.service;

import com.chemcool.school.tasks.chemsingleselect.domain.ChemSingleSelectTask;
import com.chemcool.school.tasks.chemsingleselect.domain.ChemSingleSelectTaskEvent;
import org.springframework.stereotype.Service;

@Service
public class ChemSingleSelectTaskEventService {
    public void save(ChemSingleSelectTask task) {
        //todo написать реализацию
        ChemSingleSelectTaskEvent event = ChemSingleSelectTaskEvent.createEvent(task);
    }

    public void update(ChemSingleSelectTask task) {
        //todo написать реализацию
    }
}
