package com.chemcool.school.tasks.service.implementations;

import com.chemcool.school.tasks.domain.SingleSelectTask;
import com.chemcool.school.tasks.infrastructure.storage.SingleSelectRepository;
import com.chemcool.school.tasks.service.SingleSelectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author : Constantine Lee
 * @Date : 24.10.2021
 * @e-mail : rhowbn@gmail.com
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class SingleSelectServiceImpl implements SingleSelectService {

    private final SingleSelectRepository repository;

    @Override
    public SingleSelectTask save(SingleSelectTask task) {
        SingleSelectTask baseTask = repository.save(task);
        log.info("Task with id {} was saved", baseTask.getTaskId());
        return baseTask;
    }
}
