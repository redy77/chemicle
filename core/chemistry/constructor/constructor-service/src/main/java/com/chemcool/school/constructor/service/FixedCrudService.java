package com.chemcool.school.constructor.service;

import com.chemcool.school.constructor.domain.FixedAnswerTask;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FixedCrudService {

    private final FixedCrudRepository fixedCrudRepository;

    public void addQuestion (FixedAnswerTask fixedAnswerTask) {
        fixedCrudRepository.save(fixedAnswerTask);
    }
}
