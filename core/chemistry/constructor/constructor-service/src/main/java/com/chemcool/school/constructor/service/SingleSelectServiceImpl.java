package com.chemcool.school.constructor.service;

import com.chemcool.school.constructor.domain.SingleSelectPresentation;
import com.chemcool.school.constructor.domain.SingleSelectTask;
import com.chemcool.school.constructor.infrastructure.storage.SingleSelectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SingleSelectServiceImpl implements SingleSelectService {

    private final SingleSelectRepository repository;

    @Autowired
    public SingleSelectServiceImpl(SingleSelectRepository repository) {
        this.repository = repository;
    }

    @Override
    public String save(SingleSelectPresentation presentation) {
        SingleSelectTask task = presentation.convertToTask();
        repository.save(task);
        return task.getTaskId();
    }
}
