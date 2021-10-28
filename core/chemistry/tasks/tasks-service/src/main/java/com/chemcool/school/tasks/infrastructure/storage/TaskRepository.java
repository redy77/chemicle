package com.chemcool.school.tasks.infrastructure.storage;

import com.chemcool.school.tasks.domain.AbstractTask;
import com.chemcool.school.tasks.statuses.TaskType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author : Constantine Lee
 * @Date : 26.10.2021
 * @e-mail : rhowbn@gmail.com
 */
@Repository
public interface TaskRepository extends JpaRepository<AbstractTask, String> {

    List<AbstractTask> findAllByTaskType(TaskType taskType);

    List<AbstractTask> findAllByChapterNum(Short chapterNum);
}
