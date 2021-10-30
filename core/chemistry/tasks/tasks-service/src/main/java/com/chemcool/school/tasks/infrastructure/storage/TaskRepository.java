package com.chemcool.school.tasks.infrastructure.storage;

import com.chemcool.school.tasks.domain.AbstractTask;
import com.chemcool.school.tasks.statuses.TaskType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TaskRepository<T extends AbstractTask> extends JpaRepository<T, String> {

    List<T> findAllByTaskType(TaskType taskType);

    List<T> findAllByChapterNum(Short chapterNum);
}
