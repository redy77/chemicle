package com.chemcool.school.tasks.chemsingleselect.storage;

import com.chemcool.school.tasks.chemsingleselect.domain.ChemSingleSelectTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChemSingleSelectTaskRepository extends JpaRepository<ChemSingleSelectTask, String> {
    List<ChemSingleSelectTask> getAllByChapterId(String chapterId);
}
