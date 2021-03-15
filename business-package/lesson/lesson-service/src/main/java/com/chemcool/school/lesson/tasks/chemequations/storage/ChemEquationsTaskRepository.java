package com.chemcool.school.lesson.tasks.chemequations.storage;

import com.chemcool.school.lesson.tasks.chemequations.domain.ChemEquationsTask;
import com.chemcool.school.lesson.tasks.chemsingleselect.domain.ChemSingleSelectTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChemEquationsTaskRepository
        extends JpaRepository<ChemEquationsTask, String>, JpaSpecificationExecutor<ChemEquationsTask> {
    List<ChemEquationsTask> getAllByChapterId(int chapterId);
    //List<ChemEquationsTask> findAllByChapterIdAndReferenceId(int chapterId,int referenceId);
    List<ChemEquationsTask> findChemEquationsTaskByChapterId(int chapterId);
    List<ChemEquationsTask> findChemEquationsTaskByReferenceId(int referenceId);
}


