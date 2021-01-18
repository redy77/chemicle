package com.chemcool.school.tasks.singleselectquestion.storage;

import com.chemcool.school.tasks.singleselectquestion.domain.ChemistrySingleSelectTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChemistrySingleSelectTaskRepository extends JpaRepository<ChemistrySingleSelectTask, String> {
    List<ChemistrySingleSelectTask> getAllByChapterId(String chapterId);
}
