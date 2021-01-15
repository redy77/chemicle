package com.chemcool.school.tasks.storage;

import com.chemcool.school.tasks.domain.ChemistryMatchingTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ChemistryMatchingTaskRepository extends JpaRepository<ChemistryMatchingTask, UUID> {
    List<ChemistryMatchingTask> findByChapterId(String id);
}
