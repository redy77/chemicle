package com.chemcool.school.lesson.tasks.chemsingleselect.storage;

import com.chemcool.school.lesson.tasks.chemsingleselect.domain.ChemSingleSelectTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChemSingleSelectTaskRepository extends JpaRepository<ChemSingleSelectTask, String> {
    List<ChemSingleSelectTask> getAllByChapterId(int chapterId);
    List<ChemSingleSelectTask> getAllByReferenceId(int referenceId);
    List<ChemSingleSelectTask> getAllByReferenceIdAndChapterId(int referenceId, int chapterId);

}