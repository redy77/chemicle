package com.chemcool.school.tasks.service.implementations;

import com.chemcool.school.tasks.domain.Comparison;
import com.chemcool.school.tasks.domain.SingleSelectTask;
import com.chemcool.school.tasks.infrastructure.storage.ComparisonRepository;
import com.chemcool.school.tasks.service.ComparisonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author : Constantine Lee
 * @Date : 25.10.2021
 * @e-mail : rhowbn@gmail.com
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ComparisonServiceImpl implements ComparisonService {

    private final ComparisonRepository repository;

    @Override
    public Comparison save(Comparison task) {
        Comparison baseTask = repository.save(task);
        log.info("Task with id {} was saved", baseTask.getTaskId());
        return baseTask;
    }
}
