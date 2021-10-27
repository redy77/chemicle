package com.chemcool.school.tasks.service;


import com.chemcool.school.tasks.domain.AbstractTask;
import com.chemcool.school.tasks.models.Task;

import java.util.List;

/**
 * @Author : Constantine Lee
 * @Date : 26.10.2021
 * @e-mail : rhowbn@gmail.com
 */
public interface TaskService {
    AbstractTask save(AbstractTask task);

    List<AbstractTask> findAll();
}
