package com.chemcool.school.lesson.storage.equation;

import com.chemcool.school.lesson.domain.equation.ChemEquationsTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChemEquationsTaskRepository
        extends JpaRepository<ChemEquationsTask, String>, JpaSpecificationExecutor<ChemEquationsTask> {
    List<ChemEquationsTask> findAllByChapterId(Integer chapterId);
    List<ChemEquationsTask> findAllByReferenceIdAndChapterId(Integer referenceId, Integer chapterId);
    List<ChemEquationsTask> findAllByReferenceId(Integer referenceId);
}


