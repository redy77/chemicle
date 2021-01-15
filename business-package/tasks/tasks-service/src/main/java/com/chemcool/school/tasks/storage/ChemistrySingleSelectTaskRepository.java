package com.chemcool.school.tasks.storage;

import com.chemcool.school.tasks.domain.ChemistrySingleSelectTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChemistrySingleSelectTaskRepository extends JpaRepository<ChemistrySingleSelectTask, String> {
    List<ChemistrySingleSelectTask> getAllByChapterId(String id);
}