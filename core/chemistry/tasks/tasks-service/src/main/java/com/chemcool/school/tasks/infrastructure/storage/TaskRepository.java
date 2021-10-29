package com.chemcool.school.tasks.infrastructure.storage;

import com.chemcool.school.tasks.domain.AbstractTask;
import com.chemcool.school.tasks.domain.exceptions.TaskNotFoundException;
import com.chemcool.school.tasks.statuses.TaskType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @Author : Constantine Lee
 * @Date : 26.10.2021
 * @e-mail : rhowbn@gmail.com
 */
@Repository
public interface TaskRepository<T extends AbstractTask> extends JpaRepository<T, String> {

    List<T> findAllByTaskType(TaskType taskType);

    List<T> findAllByChapterNum(Short chapterNum);
}
