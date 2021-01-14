package com.chemcool.school.tasks.storage;

import com.chemcool.school.tasks.domain.ChemistryEquationTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ChemistryEquationTaskRepository extends JpaRepository<ChemistryEquationTask, UUID> {
    List<ChemistryEquationTask> getAllByChapterId(String id);
}
