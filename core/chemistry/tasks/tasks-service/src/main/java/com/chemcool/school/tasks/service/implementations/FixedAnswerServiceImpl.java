package com.chemcool.school.tasks.service.implementations;

import com.chemcool.school.tasks.domain.FixedAnswerTask;
import com.chemcool.school.tasks.domain.SingleSelectTask;
import com.chemcool.school.tasks.infrastructure.storage.FixedAnswerRepository;
import com.chemcool.school.tasks.service.FixedAnswerService;
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
public class FixedAnswerServiceImpl implements FixedAnswerService {

    private final FixedAnswerRepository repository;
    @Override
    public FixedAnswerTask save(FixedAnswerTask task) {
        FixedAnswerTask baseTask = repository.save(task);
        log.info("Task with id {} was saved", baseTask.getTaskId());
        return baseTask;
    }
}
