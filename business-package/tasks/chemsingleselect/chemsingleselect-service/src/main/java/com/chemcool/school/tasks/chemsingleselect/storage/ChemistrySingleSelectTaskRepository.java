package com.chemcool.school.tasks.chemsingleselect.storage;

import com.chemcool.school.tasks.chemsingleselect.domain.ChemistrySingleSelectTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChemistrySingleSelectTaskRepository extends JpaRepository<ChemistrySingleSelectTask, String> {
    List<ChemistrySingleSelectTask> getAllByChapterId(String chapterId);
}
